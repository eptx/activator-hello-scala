package scalatest

import org.scalatest.FunSuite
import scala.pickling._
import json._
//import binary._


case class Acct(val id: Int)
case class Client(val name: String, val accts: List[Acct])

class Test12 extends FunSuite {
	test("Pickle, unpickle") {
		val xi = (1 to 5).toList
		val xip = xi.pickle
		println(xip)
		assert(xi === xip.unpickle[List[Int]])
		
		val xc = ('a' to 'd').toList
		val xcp = xc.pickle
		println(xcp)
		assert(xc === xcp.unpickle[List[Char]])	
		
		val al:List[Acct] = genAccts(5)
		println(al.pickle)
		assert(al === al.pickle.unpickle[List[Acct]])	
		
		val c1 = Client("My Client",genAccts(3))
		println(c1.pickle)
		assert(c1 === c1.pickle.unpickle[Client])
		
		val clients = List(
			Client("Client 1",genAccts(3)),
			Client("Client 2",genAccts(2)),
			Client("Client 3",genAccts(5))
		)
		println(clients.pickle)
		assert(clients === clients.pickle.unpickle[List[Client]])
	}
	
	/*
	ignore("Large Pickle, unpickle") {
		val count = 10
		val clients: List[Client] = (for{c <- (1 to count)} yield Client("Client "+c,genAccts(3))).toList	
		//assert(clients(5) === clients.pickle.unpickle[List[Client]](5))	
	}
	*/
	def genAccts(n: Int):List[Acct] = {
		println("accts:$n")
		(for{a <- (1 to n)} yield Acct(a)).toList			
	}
}