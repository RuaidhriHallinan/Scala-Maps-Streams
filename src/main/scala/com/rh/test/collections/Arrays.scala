package com.rh.test.collections

/**
 * An Array is a data structure where each element is stored in a continuous sequence and is referenced by an index.
 */
object Arrays extends App {

  var days = Array("Mon", "Tue", "Wed", "Thurs", "Fri", "Sat", "Sun")
  println(days(0))

  //Update to array
  days(0) = "Monday"
  println(days(0))

  //Adding to array
  println("\nAdding to array")
  var names = new Array[String](4)
  names(0) = "Matthew"
  names(1) = "Mark"
  names(2) = "Luke"
  names(3) = "John"

  //Iterate and print names foreach
  println("\nIterate and print names foreach")
  names.foreach {
    n => println(n)
  }

  //Iterate and print names for loop
  println("\nIterate and print names for loop")
  for (i <- names) {
    println(i)
  }

  //Concatenate arrays
  var arr1 = Array(1, 2, 3, 4, 5)
  var arr2 = Array(6, 7, 8, 9, 10)

  var arr3 = arr1 ++ arr2
  println("\nConcatenating arrays")
  for (i <- arr3) {
    println(i)
  }

  //Multidemensional arrays
  //This is Multidemensional array represents multiple rows (left), with column values(right)
  val rows = 2
  val cols = 3

  val books = Array.ofDim[String](rows, cols)
  books(0)(0) = "JK Rowling"
  books(0)(1) = "Harry Potter"
  books(0)(2) = "The Philosophers Stone"

  books(1)(0) = "JRR Tolken"
  books(1)(1) = "Lord of The Rings"
  books(1)(2) = "The Fellowship of The Ring"

  //Iterating through Multidemensional Array
  println("\nIterating through Multidemensional Array")
  for (i <- 0 until rows; j <- 0 until cols) {
     // Printing values
     println(s"($i)($j) = ${books(i)(j)}")
   }


  //Appending and & Prepending values to Arrays
  println("\nAppending and & Prepending values to Arrays")

  val nums = Array(1,2,3,4,5)

  println("Array nums: ")
    nums.foreach(println(_))

  println("\nAppending 1 item")
  val appendNums = nums :+ 6
    appendNums.foreach(println(_))

  println("\nAppending more items")
  val appendMoreNums = appendNums ++ Array(7,8)
    appendMoreNums.foreach(println(_))

  println("\nPrepending an item")
  val prependedItems = 0 +: appendMoreNums
    prependedItems.foreach(println(_))

  println("\nPrepending more items")
  val prependMoreItems = Array(-2, -1) ++: prependedItems
    prependMoreItems.foreach(println(_))

  println("\nSumming all elements in a normal array")
  var n : Int = 0
  nums.foreach { r =>
    n = n + r
  }
  println(n)

  println("\nFinding the largest element in the array:")
  var max = nums(0)
  nums.foreach { r =>
    if(r > max) max = nums(r -1)
  }
  println("Max is " + max)

}


