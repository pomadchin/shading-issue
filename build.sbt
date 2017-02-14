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
  "-feature"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5-M1",
  "com.github.scopt" %% "scopt" % "3.5.0" // random library to shade (has no transitive deps)
)

// Since Akka 2.4-M1: (2.3.16 would work with shading)
// 1. not to shade = everything works OR
// 2. to shade and to use -noverify jar flag = everything works
// otherwise stackmap exception

assemblyShadeRules in assembly := {
  val shadePackage = "com.azavea.shaded.demo"
  Seq(
    ShadeRule.rename("com.github.scopt.**" -> s"$shadePackage.com.github.scopt.@1").inAll
  )
}

test in assembly := {}
