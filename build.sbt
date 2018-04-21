name := """quote-manager"""
organization := "ir.kashipazha"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"


libraryDependencies += guice

// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.11.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.11.0"

// https://mvnrepository.com/artifact/org.hibernate/hibernate-core
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.16.Final"

// https://mvnrepository.com/artifact/org.postgresql/postgresql
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.2"

// https://mvnrepository.com/artifact/org.hibernate/hibernate-c3p0
libraryDependencies += "org.hibernate" % "hibernate-c3p0" % "5.2.16.Final"


// https://github.com/playframework/playframework/blob/2.6.x/framework/project/Dependencies.scala#L11
val akkaVersion = "2.5.12"

dependencyOverrides ++= Seq( // Seq for SBT 1.0.x
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.google.guava" % "guava" % "22.0",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.jboss.logging" % "jboss-logging" % "3.3.2.Final",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.0"
)
