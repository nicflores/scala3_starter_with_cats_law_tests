ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file(".")).settings(
  name := "property-based-testing-with-discipline",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.12",
    "org.typelevel" %% "cats-effect-kernel" % "3.3.12",
    "org.typelevel" %% "cats-effect-std" % "3.3.12",
    "org.typelevel" %% "cats-effect-testing-specs2" % "1.4.0" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
  )
)
