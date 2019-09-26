package com.event.model

import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import org.specs2.mutable._

class AddressSpec extends Specification {
  "encode" should {
    "creates json string" in {
      val address: Address = Address("street", "Melbourne", "3000")
      val json: String = "{\"street\":\"street\",\"city\":\"Melbourne\",\"postCode\":\"3000\"}"
      address.asJson.noSpaces mustEqual json
    }

    "creates object from json string" in {
      val json: String = "{\"street\":\"street\",\"city\":\"Melbourne\",\"postCode\":\"3000\"}"
      val address: Address = Address("street", "Melbourne", "3000")
      decode[Address](json) must beRight(address)
    }
  }
}
