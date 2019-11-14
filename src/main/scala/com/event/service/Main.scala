package com.event.service

import cats.effect.IO
import com.event.model.Event
import com.event.repositories.EventRepositoryImpl

object Main extends App {

  implicit val eventRepositoryImpl = new EventRepositoryImpl[IO]
  implicit val eventServiceImpl = new EventServiceImpl[IO]

  print(EventService[IO].currentEvents().unsafeRunSync())

//  def putStrLn(line: String): IO[Unit] = IO(println(line))
//  def getStrLn: IO[String] = IO(scala.io.StdIn.readLine())
//
//
//  val toPrint: IO[String] = for {
//    _ <- putStrLn("adad")
//    x <- getStrLn
//    _ <- putStrLn(s"adad${x}")
//  } yield x
//
//  toPrint.unsafeRunSync()
}
