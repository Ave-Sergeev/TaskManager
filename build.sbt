name := "Http4s"
version := "0.1"
scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "org.http4s"              %% "http4s-blaze-server"      % "0.23.11",
  "org.http4s"              %% "http4s-blaze-client"      % "0.23.11",
  "org.http4s"              %% "http4s-dsl"               % "0.23.11"
)
