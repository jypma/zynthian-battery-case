scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "io.github.dzufferey" %% "scadla" % "0.1-SNAPSHOT"
)

resolvers +=  "dzufferey maven repo" at "https://github.com/dzufferey/my_mvn_repo/raw/master/repository"
