package scalatest

import org.scalatest.FunSuite

class Test01 extends FunSuite {
	test("Very Basic") {
  	assert(1 == 1)
	}
  ignore("Another Very Basic") {
  	assert("Hello World" == "Hi")
	}
	
}