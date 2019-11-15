package com.event.repositories

import cats.effect.Bracket
import com.event.model.Event
import doobie._
import doobie.implicits._

trait EventRepository[F[_]] {
  def findEvent(eventId: String): F[Option[Event]]
  def fetchAllEvents(): F[Vector[Event]]
}

class EventRepositoryImpl[F[_] : Bracket[*[_], Throwable]](val xa: Transactor[F])
  extends EventRepository[F] {
  def findEvent(eventId: String): F[Option[Event]] =
    sql"""SELECT * FROM event WHERE id=$eventId""".query[Event].option.transact(xa)

  def fetchAllEvents(): F[Vector[Event]] =
    sql"""SELECT * FROM event""".query[Event].to[Vector].transact(xa)
}

object EventRepository {
  def apply[F[_] : Bracket[*[_], Throwable] : Transactor[F]]
  (implicit xa: Transactor[F]): EventRepository[F] =
    new EventRepositoryImpl(xa)
}
