package com.event

import com.event.model.{Request, Uri}
import org.http4s.Method
import org.scalatest.{FunSpec, Matchers}

class ScalaSimpleSpec extends FunSpec with Matchers {

  describe("Hello world") {
    it("makes a request") {
      val request = Request(Method.POST, Uri("/hello"), "Testing")
      "Hello, Testing".shouldEqual(HelloWorld.request(request).body)
    }
  }
}
