package com.event.service

import cats.Monad
import cats.effect.{IO, Sync}
import com.event.model.Event
import com.event.repositories.EventRepository

trait EventService[F[_]] {
  def findEvent(eventId: String): F[Option[Event]]

  def currentEvents(): F[List[Event]]
}

class EventServiceImpl[F[_] : Sync : EventRepository] extends EventService[F] {
  def findEvent(eventId: String): F[Option[Event]] =
    EventRepository[F].findEvent(eventId)

  def currentEvents(): F[List[Event]] = {
    Sync[F].map(EventRepository[F].fetchAllEvents())(x => x.filter(e => e.title.equals("t1")))
  }
}

object EventService {
  def apply[F[_]](implicit F: EventService[F]): EventService[F] = F
}
