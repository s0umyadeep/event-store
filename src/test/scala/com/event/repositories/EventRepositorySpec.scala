package com.event.repositories

import cats.effect.IO
import doobie.util.ExecutionContexts
import doobie.util.transactor.Transactor
import org.specs2.mutable.Specification

object EventRepositorySpec extends Specification with doobie.specs2.IOChecker {

  implicit val cs = IO.contextShift(ExecutionContexts.synchronous)

  implicit val transactor = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql:postgres", "postgres", ""
  )
  check(EventQuery.events("0"))
}
