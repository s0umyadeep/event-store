package com.event.model

import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.{Decoder, Encoder, HCursor, Json}

case class Event(id: String, title: String, duration: Duration, location: Address, description: Description)

object Event {
  implicit val encoder: Encoder[Event] = (event: Event) => Json.obj(
    ("id", event.title.asJson),
    ("title", event.title.asJson),
    ("duration", event.duration.asJson),
    ("location", event.location.asJson),
    ("description", event.description.asJson)
  )

  implicit val decoder: Decoder[Event] = (cursor: HCursor) => for {
    id <- cursor.downField("id").as[String]
    title <- cursor.downField("title").as[String]
    duration <- cursor.downField("duration").as[Duration]
    location <- cursor.downField("location").as[Address]
    description <- cursor.downField("description").as[Description]
  } yield Event(id, title, duration, location, description)
}