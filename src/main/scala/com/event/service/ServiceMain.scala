package com.event.service

import cats.effect.IO
import com.event.model.Event
import com.event.repositories.{EventRepository, EventRepositoryImpl}
import doobie.util.ExecutionContexts
import doobie.util.transactor.Transactor

object ServiceMain extends App {
  implicit val cs = IO.contextShift(ExecutionContexts.synchronous)

  implicit val transactor = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql:postgres", "postgres", ""
  )
  val eventRepository: EventRepository[IO] = EventRepository[IO]
  EventService[IO](eventRepository).findEvent("12")
}
