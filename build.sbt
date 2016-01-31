//name := "scala-spring"

//version := "1.0.0"

//for sbt ONLY
lazy val root = (project in file(".")).
  settings(
    name := "scala-spring",
    version := "1.0.0",
    scalaVersion := "2.11.7"
  )

enablePlugins(JavaServerAppPackaging)
//enablePlugins(TomcatPlugin)

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.3.2.RELEASE"
)

//libraryDependencies ++= Seq(
//  "com.google.guava" % "guava" % "18.0"
//)

//libraryDependencies ++= Seq(
//  "org.springframework.boot" % "spring-boot-starter-data-rest" % "1.0.0.RELEASE"
//)

libraryDependencies ++= Seq(
  "org.springframework.data" % "spring-data-rest-webmvc" % "2.4.2.RELEASE"
)

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-data-jpa" % "1.3.2.RELEASE"
)

//libraryDependencies ++= Seq(
//  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.0"
//)

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "9.4.1207.jre7"
)

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _ )