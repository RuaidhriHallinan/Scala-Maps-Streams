package com.rh.test.basics

object TupleExample extends App {

  val (var1, var2) = (100, "Description")
  println(var1)
  println(var2)

  val toupleVals = (100, "Description")
  println(toupleVals)

  //tuple holding an integer, a string, and Object
  val t = (1, "hello", TupleExample) //or... val t = new Tuple3(1, "hello", Console)

  println("t._1: " + t._1)
  println("t._2: " + t._2)
  println("t._3: " + t._3)

  t.productIterator.foreach( i =>
    println("Iterating over Tuple:" + i)
  )

  println("\nt.toString: " + t.toString())

  //Swapping touple 2
  val t2 = Tuple2("Scala", "hello")
  println("\nt.toString: " + t2.swap)

}
