sbtPlugin := true

name := "sbt-checkstyle-plugin"

organization := "com.etsy"

version := "3.0.1-SNAPSHOT"

crossSbtVersions := List("0.13.17", "1.1.1")

scalaVersion := {
  (sbtBinaryVersion in pluginCrossBuild).value match {
    case "0.13" => "2.10.6"
    case _      => "2.12.4"
  }
}

libraryDependencies ++= Seq(
  "com.puppycrawl.tools" % "checkstyle" % "6.15",
  "net.sf.saxon" % "Saxon-HE" % "9.6.0-5",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "junit" % "junit" % "4.11" % Test,
  "com.github.stefanbirkner" % "system-rules" % "1.6.0" % Test
)

xerial.sbt.Sonatype.sonatypeSettings

pomExtra := <url>https://github.com/etsy/sbt-checkstyle-plugin</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:etsy/sbt-checkstyle-plugin.git</url>
    <connection>scm:git:git@github.com:etsy/sbt-checkstyle-plugin.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ajsquared</id>
      <name>Andrew Johnson</name>
      <url>github.com/ajsquared</url>
    </developer>
  </developers>

scalastyleConfig := file("scalastyle.xml")

scalastyleFailOnError := true
