name := "rational-scala"
organization := "com.github.kamijin_fanta"
version := "1.0.0"
scalaVersion := "2.11.7"
crossScalaVersions := Seq("2.11.7","2.10.5")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0-M9"
publishTo := Some(Resolver.file("hello", file("repository"))(Patterns(true, Resolver.mavenStyleBasePattern)))
initialCommands := """
                     |import com.github.kamijin_fanta.math.Rational
                     |import com.github.kamijin_fanta.math.RationalImplicits._
                   """.stripMargin
