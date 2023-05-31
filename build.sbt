ThisBuild / organization := "com.pbtwd"
ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file(".")).settings(
  name := "property-based-testing-with-discipline",
  scalacOptions ++= Seq(
    // "-Wunused:imports",
    // "-Wunused:privates",
    // "-Wunused:locals",
    // "-Wunused:explicits",
    // "-Wunused:implicits",
    // "-Wunused:params",
    "-Wunused:all"
  ),
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.12",
    // "org.typelevel" %% "cats-effect-kernel" % "3.3.12",
    // "org.typelevel" %% "cats-effect-std" % "3.3.12",
    // Discipline and FunSuiteDiscipline
    "org.typelevel" %% "discipline-scalatest" % "2.2.0" % Test,
    // AnyFunSuite & PropertyCheckConfiguration
    "org.scalatest" %% "scalatest" % "3.2.9" % Test,
    // OrderTests
    "org.typelevel" %% "cats-laws" % "2.9.0" % Test,
    // Arbitrary & Gen
    "org.scalacheck" %% "scalacheck" % "1.17.0" % Test,
    // remove these once we clean up HelloWorldSpec & Suite
    "org.typelevel" %% "cats-effect-testing-specs2" % "1.4.0" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
  )
)
