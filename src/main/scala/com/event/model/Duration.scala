package com.event.model

import io.circe.{Decoder, Encoder, HCursor, Json}
import org.joda.time.DateTime

case class Duration(from: DateTime, to: DateTime)

object Duration {
  implicit val encoder: Encoder[Duration] = (duration: Duration) => Json.obj(
    ("from", Json.fromString(duration.from.toString())),
    ("to", Json.fromString(duration.to.toString()))
  )

  implicit val decoder: Decoder[Duration] = (cursor: HCursor) => for {
    from <- cursor.downField("from").as[String]
    to <- cursor.downField("to").as[String]
  } yield Duration(DateTime.parse(from), DateTime.parse(to))
}
