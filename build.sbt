name := "miwa-crm"

version := "1.0"

lazy val `miwa-crm` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq( javaJdbc , javaEbean , cache , javaWs )

libraryDependencies += "com.mashape.unirest" % "unirest-java" % "1.4.7"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1207.jre7"

libraryDependencies += "commons-net" % "commons-net" % "3.3"

libraryDependencies += "com.rabbitmq" % "amqp-client" % "3.5.6"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  