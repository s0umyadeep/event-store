package com.event.repositories

import cats.effect.Sync
import com.event.model.Event

trait EventRepository[F[_]] {
  def findEvent(eventId: String): F[Option[Event]]

  def fetchAllEvents(): F[List[Event]]
}

class EventRepositoryImpl[F[_]](implicit F: Sync[F]) extends EventRepository[F] {
  def findEvent(eventId: String): F[Option[Event]] =
    F.delay(Option(Event("t45", null, null, null)))

  def fetchAllEvents(): F[List[Event]] =
    F.delay(List(Event("t1", null, null, null), Event("t2", null, null, null)))
}

object EventRepository {
  def apply[F[_]](implicit F: EventRepository[F]): EventRepository[F] = F
}
