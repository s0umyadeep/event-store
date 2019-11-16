package com.event.model

import io.circe.parser.decode
import io.circe.syntax._
import org.joda.time.DateTime
import org.specs2.mutable._

class EventSpec extends Specification {
//  "encoder" should {
//    "convert Event to json string" in {
//
//      val address: Address = Address("street", "Melbourne", "3000")
//      val now: DateTime = DateTime.parse("2019-03-24T00:00:00.000Z")
//      val duration: Duration = Duration(now,DateTime.parse("2020-03-24T00:00:00.000Z"))
//      val description: Description = Description("content", "website", "ticketInfo")
//      val event: Event = Event("title", duration, address, description)
//      val json: String = "{\"title\":\"title\",\"duration\":{\"from\":\"2019-03-24T00:00:00.000Z\",\"to\":\"2020-03-24T00:00:00.000Z\"},\"location\":{\"street\":\"street\",\"city\":\"Melbourne\",\"postCode\":\"3000\"},\"description\":{\"content\":\"content\",\"website\":\"website\",\"ticketInfo\":\"ticketInfo\"}}"
//      event.asJson.noSpaces must_=== json
//    }
//  }
//
//  "decoder" should {
//    "create object from json string" in {
//      val address: Address = Address("street", "Melbourne", "3000")
//      val now: DateTime = DateTime.parse("2019-03-24T00:00:00.000Z")
//      val duration: Duration = Duration(now,DateTime.parse("2020-03-24T00:00:00.000Z"))
//      val description: Description = Description("content", "website", "ticketInfo")
//      val event: Event = Event("title", duration, address, description)
//      val json: String = "{\"title\":\"title\",\"duration\":{\"from\":\"2019-03-24T00:00:00.000Z\",\"to\":\"2020-03-24T00:00:00.000Z\"},\"location\":{\"street\":\"street\",\"city\":\"Melbourne\",\"postCode\":\"3000\"},\"description\":{\"content\":\"content\",\"website\":\"website\",\"ticketInfo\":\"ticketInfo\"}}"
//      decode[Event](json) must beRight(event)
//    }
//  }
}
