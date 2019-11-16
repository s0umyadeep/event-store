package com.event.repositories

import java.util.UUID

import doobie.util.transactor.Transactor
import doobie._
import doobie.implicits._
import doobie.util.ExecutionContexts
import cats._
import cats.data._
import cats.effect._
import cats.implicits._

import com.event.model.Event

object RepMain extends App {

  implicit val cs = IO.contextShift(ExecutionContexts.synchronous)

  implicit val transactor = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql:postgres", "postgres", ""
  )

  def biggerThan(id: String) = sql"""
   SELECT id, title
   FROM event
   WHERE title = $id
""".query[Event]

  //ra"b93067bb-1933-4d20-ace3-c4446ee9dc8c"
  val x: doobie.ConnectionIO[Option[Event]] = biggerThan("b93067bb-1933-4d20-ace3-c4446ee9dc8c").option
  val y: doobie.ConnectionIO[Either[Throwable, Option[Event]]] = x.attempt
  val z: Either[Throwable, Option[Event]] = y.transact(transactor).unsafeRunSync
  println(z)
  z match {
    case Left(value) => {
      value.printStackTrace(System.out)
    }
    case Right(value) => println(value)
  }



  //EventRepository[IO].findEvent("b93067bb-1933-4d20-ace3-c4446ee9dc8c").unsafeRunSync()
}
