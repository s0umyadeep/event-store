package com.event.model

import io.circe.{Decoder, Encoder, HCursor, Json}
import org.joda.time.DateTime

case class Duration(id: String, fromDate: DateTime, toDate: DateTime)

object Duration {
  implicit val encoder: Encoder[Duration] = (duration: Duration) => Json.obj(
    ("id", Json.fromString(duration.id.toString())),
    ("fromDate", Json.fromString(duration.fromDate.toString())),
    ("toDate", Json.fromString(duration.toDate.toString()))
  )

  implicit val decoder: Decoder[Duration] = (cursor: HCursor) => for {
    id <- cursor.downField("id").as[String]
    from <- cursor.downField("fromDate").as[String]
    to <- cursor.downField("toDate").as[String]
  } yield Duration(id, DateTime.parse(from), DateTime.parse(to))
}
