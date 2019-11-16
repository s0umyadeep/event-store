package com.event.repositories

import cats.effect.Bracket
import com.event.model.Event
import doobie._
import doobie.implicits._

trait EventRepository[F[_]] {
  def findEvent(eventId: String): F[Option[Event]]
}

class EventRepositoryImpl[F[_] : Bracket[*[_], Throwable]](val xa: Transactor[F])
  extends EventRepository[F] {

  def findEvent(eventId: String): F[Option[Event]] =
    sql"""SELECT id, title FROM event WHERE title ='$eventId'"""
      .query[Event].option.transact(xa)
}

object EventRepository {
  def apply[F[_] : Bracket[*[_], Throwable]]
  (implicit xa: Transactor[F]): EventRepository[F] =
    new EventRepositoryImpl(xa)
}
