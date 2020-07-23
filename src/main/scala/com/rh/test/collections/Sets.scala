package com.rh.test.collections

object Sets extends App {

  //Scala Set is a collection of pairwise different elements of the same type.
  // In other words, a Set is a collection that contains no duplicate elements.

  //Set of Integers
  var setNums : Set[Int] = Set(1, 2, 3, 4, 5)

  //Basic Operations - head, tail, isEmpty
  println(s"Head of set: " + setNums.head)
  println(s"Tail of set: " + setNums.tail)
  println(s"Check is set empty: " + setNums.isEmpty)

  var otherNums = Set(6, 7, 8, 9)

  //Concatination
  var newNums = setNums ++ otherNums
  println(s"\nnewNums contatenated ++: " + newNums)

  newNums = setNums.++(otherNums)
  println(s"\nnewNums contatenated .++(): " + newNums)

  //Find Min/max elements in Set
  println(s"\nMin element in Set: " + newNums.min)
  println(s"\nMax element in Set: " + newNums.max)

  //Find common elememts between two sets
  val num1 = Set(5,6,9,20,30,45)
  val num2 = Set(50,60,9,20,35,55)

  println(s"\nintersection between sets using num1.&(num2): " + num1.&(num2))
  println(s"\nintersection between sets using num1.intersect(num2): " + num1.intersect(num2))

}
