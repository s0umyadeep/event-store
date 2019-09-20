package com.event

import com.event.model.{Request, Response, Uri}
import org.http4s.{HttpApp, Method, Status}

object HelloWorld {
  type HttpAppX = Request => Response

  def request: Request => Response = {
    case Request(Method.POST, Uri("/hello"), name) =>
      Response(Status.Ok, s"Hello, ${name}")
    case _ =>
      Response(Status.NotFound, "")
  }
}
