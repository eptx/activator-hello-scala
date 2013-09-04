package scalatest

import org.scalatest._
import akka.actor._
import scala.concurrent._
import scala.concurrent.duration._

class Test11 extends FunSuite with BeforeAndAfterAll {
	
	test("Spray Http Client, Akka, Futures") {
		import spray.http._
		import spray.client.pipelining._
		import system.dispatcher

		val pipeline: HttpRequest => Future[HttpResponse] = sendReceive
		val response: Future[HttpResponse] = pipeline(Get(s"http://localhost:${_port}/hello"))
		response onSuccess {
			case HttpResponse(status,httpEntity,headers,protocol) => 
				assert(httpEntity.asString === "hi")
		}
		shutdown()
	}
	
	def shutdown(): Unit = {
			system.scheduler.scheduleOnce(2.second)(system.shutdown())(system.dispatcher)
	  }
	
	
	//Spray server management
	import spray.routing.SimpleRoutingApp

	implicit val system = ActorSystem("system")
	val _port = 8091
	
		object Server extends SimpleRoutingApp {
		  startServer(interface = "localhost", port = _port) {
				get {
					path("hello") {
						complete {"hi"}
					}
				}
			}
		}
	
	override def beforeAll() {
		Server	
	}

	override def afterAll() {
		system.scheduler.scheduleOnce(5.second)(system.shutdown())(system.dispatcher)
	}
}

