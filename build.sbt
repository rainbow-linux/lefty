name := "gay.rainbowlinux.infra.cd.lefty"
version := "0.1.0"
scalaVersion := "2.13.14"

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

val AkkaVersion = "2.9.5"
libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
    "com.typesafe.akka" %% "akka-cluster-typed" % AkkaVersion,
    "org.scala-lang" %% "toolkit" % "0.1.7",
    "ch.qos.logback" % "logback-classic" % "1.2.10",
)
