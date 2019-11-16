package com.event.service

import cats.Monad
import cats.syntax.all._
import com.event.model.Event
import com.event.repositories.EventRepository

trait EventService[F[_]] {
  def findEvent(eventId: String): F[Either[EventError, Option[Event]]]
}

class EventServiceImpl[F[_] : Monad](eventRepository: EventRepository[F])
  extends EventService[F] {

  def findEvent(eventId: String): F[Either[EventError, Option[Event]]] = {
    eventRepository.findEvent(eventId).flatMap {
      case Some(event) => Monad[F].pure(Some(event).asRight)
      case None => Monad[F].pure(EventError().asLeft)
    }
  }
}

object EventService {
  def apply[F[_] : Monad](eventRepository: EventRepository[F]): EventService[F] =
    new EventServiceImpl(eventRepository)
}
