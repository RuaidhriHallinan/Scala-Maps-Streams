package com.rh.test.maps

import scala.collection.immutable.HashMap

object HashMapCRUID extends App {

  //Declaring hashMap
  var hashMapVals = HashMap(
    "C" -> "C#",
    "S" -> "Scala",
    "J" -> "Java",
    "K" -> "Kotlin")

  //Iterating through and printing keys/values
  def printMap: Unit = {
    hashMapVals.foreach
    {
      case (key, value) => println (key + " -> " + value)
    }

    println("\n")
  }

  println(hashMapVals + "\n")
  printMap

  //Iterating through and printing Objects in map
  hashMapVals.foreach { r =>
    println(r)
  }

  // Accessing value by using key
  println("\nAccess value for K key: " + hashMapVals("K"))

  println("\nAdding Perl")
  hashMapVals += ("P" -> "Perl")
  printMap

  println("\nRemoving C")
  hashMapVals -= ("C")
  printMap

}
