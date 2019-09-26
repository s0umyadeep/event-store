package com.event.model

import io.circe.parser.decode
import io.circe.syntax._
import org.joda.time.DateTime
import org.specs2.mutable._

class DurationSpec extends Specification {

  "encode" should {
    "creates json string" in {
      val now: DateTime = DateTime.parse("2019-03-24T00:00:00.000Z")
      val duration: Duration = Duration(now,DateTime.parse("2020-03-24T00:00:00.000Z"))
      val json: String = "{\"from\":\"2019-03-24T00:00:00.000Z\",\"to\":\"2020-03-24T00:00:00.000Z\"}"
      duration.asJson.noSpaces mustEqual json
    }
  }

  "decode" should {
    "gets object from json string" in {
      val now: DateTime = DateTime.parse("2019-03-24T00:00:00.000Z")
      val duration: Duration = Duration(now,DateTime.parse("2020-03-24T00:00:00.000Z"))
      val json: String = "{\"from\":\"2019-03-24T00:00:00.000Z\",\"to\":\"2020-03-24T00:00:00.000Z\"}"
      decode[Duration](json) must beRight(duration)
    }
  }
}
