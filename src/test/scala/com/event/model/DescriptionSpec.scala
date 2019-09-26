package com.event.model

import io.circe.generic.auto._
import io.circe.parser.decode
import io.circe.syntax._
import org.specs2.mutable._

class DescriptionSpec extends Specification {
  "encode" should {
    "creates json string" in {
      val description: Description = Description("content", "website", "ticketInfo")
      val json: String = "{\"content\":\"content\",\"website\":\"website\",\"ticketInfo\":\"ticketInfo\"}"
      description.asJson.noSpaces mustEqual json
    }
  }

  "decode" should {
    "creates object from json string" in {
      val json: String = "{\"content\":\"content\",\"website\":\"website\",\"ticketInfo\":\"ticketInfo\"}"
      val description: Description = Description("content", "website", "ticketInfo")
      decode[Description](json) must beRight(description)
    }
  }
}
