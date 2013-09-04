name := "test-patterns-scala"

version := "1.0"

scalaVersion := "2.10.2"

autoCompilerPlugins := true

resolvers += "spray repo" at "http://nightlies.spray.io"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
	 "org.scalatest"						%		"scalatest_2.10" 	%	"2.0.M6"				%	"test"
	,"org.specs2" 							%%	"specs2" 					%	"2.1.1"					%	"test"
	,"org.seleniumhq.selenium"	%		"selenium-java" 	%	"2.33.0"				%	"test"
	,"org.testng"								%		"testng"					%	"5.14.9"				%	"test"
	,"com.typesafe.akka"				%%	"akka-testkit"		%	"2.2.0"					%	"test"
	,"com.typesafe.akka"				%%	"akka-actor"			%	"2.2.0"
	,"com.typesafe.akka" 				%%	"akka-dataflow"		% "2.2.0"
	,"net.databinder.dispatch" 	%%	"dispatch-core"		% "0.11.0"
	,"com.scalarx" 							%		"scalarx_2.10" 		% "0.1"
	,"io.spray" 								% 	"spray-can" 			% "1.2-20130822"
	,"io.spray" 								% 	"spray-routing" 	% "1.2-20130822"
	,"io.spray" 								% 	"spray-client"		% "1.2-20130822"
	//,"org.scalamock" 						%%	"scalamock-scalatest-support" % "3.0.1" % "test"
	,"org.scala-lang" 					%% "scala-pickling" 	% "0.8.0-SNAPSHOT"
	//,"com.rabbitmq"						%		"amqp-client"			% "3.1.5"
)

//-oD to show test duration
testOptions in Test += Tests.Argument("-oD")

//run tests in parallel?
parallelExecution in Test := false

//to enable dataflow

libraryDependencies +=
  compilerPlugin("org.scala-lang.plugins" % "continuations" % "2.10.2")

scalacOptions += "-P:continuations:enable"

