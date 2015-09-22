
val baseSettings = Seq(
  name := "rational-scala",
  version := "1.1.0",
  scalaVersion := "2.11.7",
  crossScalaVersions := Seq("2.11.7", "2.10.5"),
  organization := "com.github.kamijin_fanta"
)

val sharedSettings = baseSettings ++ Seq(
//  unmanagedSourceDirectories in Compile <+= baseDirectory(_ /  "src" / "main" / "scala"),
//  unmanagedSourceDirectories in Test <+= baseDirectory(_ / "src" / "test" / "scala"),
  libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.0-M9",
  publishTo := Some(Resolver.file("hello", file("repository"))(Patterns(true, Resolver.mavenStyleBasePattern))),
  publishMavenStyle := true
)

lazy val root = project.in(file("."))
  .aggregate(jvm, js)
  .settings(baseSettings : _*)
  .settings(
    publish := {}
  )

lazy val library = crossProject.in(file("."))
  .settings(sharedSettings: _*)
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided"
    ),
    initialCommands := """
                         |import com.github.kamijin_fanta.math.Rational
                         |import com.github.kamijin_fanta.math.RationalImplicits._
                       """.stripMargin
  )
  .jsSettings()

lazy val js = library.js

lazy val jvm = library.jvm