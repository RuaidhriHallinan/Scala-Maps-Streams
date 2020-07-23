package com.rh.test.basics

object BasicObject extends App {

  //var
  var changeableMuteableValue : String = "I can be changed"

  //inferred value (Int inferred)
  var inferredValue = 10

  //val
  val unchangableImmutable : String = "I cant be changed"

  //lazy val
  lazy val lazyUnchangableImmutable = "I cant be changed either, and I cant be seen until now"

  //methodName
  def methodName(str : String) : String = {
    println(str)
    str
  }

  //functional val
  val doSomethingFunctional = methodName("print this")

  //use functional val
  println(doSomethingFunctional + " again")

  //use lazy val
  println(lazyUnchangableImmutable)

}
