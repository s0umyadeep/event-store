package com.event.model

import org.http4s.{Method, Status}

case class Request(method: Method, uri: Uri, body: String)
case class Response(status: Status, body: String)
