package scalatest

import org.scalatest.FunSuite
import scala.pickling._
import json._
//import binary._


class Test12 extends FunSuite {
	test("Basic Pickle, unpickle") {
		val xi = (1 to 5).toList
		val xip = xi.pickle
		println(xip)
		val xc = ('a' to 'd').toList
		val xcp = xc.pickle
		println(xcp)
		
		assert(xi === xip.unpickle[List[Int]])
		assert(xc === xcp.unpickle[List[Char]])
	}
	
	/*
	test("Tree Pickle, unpickle") {
		
		val clients: List[Client] = List(
			Client("a",List(Account("1"))),
			Client("b",List(Account("1")))
		)
		
		/*for {
			n <- List("a","b","c")
		} yield Client(n, List(Account("checking"),Account("savings")))
		*/
		val clientsPickle = clients.pickle
		
		println(clientsPickle)
		
		val clientsRestored = clientsPickle.unpickle[List[Client]]
		
		//assert(clients === clientsRestored)
		
	}
	*/
	
}

case class Account(val id: String)
case class Client(val name: String, val accounts: List[Account])