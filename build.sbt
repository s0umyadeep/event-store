name := "event-store"

version := "0.1"

scalaVersion := "2.13.0"
val http4sVersion = "0.21.0-SNAPSHOT"
val circeVersion = "0.12.1"

// Only necessary for SNAPSHOT releases
resolvers += Resolver.sonatypeRepo("snapshots")

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds")

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.0.0-RC1",
  "org.typelevel" %% "cats-effect" % "2.0.0-RC1",
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "org.scalactic" %% "scalactic" % "3.0.8",
  "joda-time" % "joda-time" % "2.10.4",
  "org.specs2" %% "specs2-core" % "4.7.1" % Test
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")