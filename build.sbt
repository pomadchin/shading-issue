name := "shading-issue"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.11.8"
crossScalaVersions := Seq("2.12.0", "2.11.8")
organization := "com.azavea"
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Yinline-warnings",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-language:higherKinds",
  "-language:postfixOps",
  "-language:existentials",
  "-feature")

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest" % "3.0.0"  % "test"
)
