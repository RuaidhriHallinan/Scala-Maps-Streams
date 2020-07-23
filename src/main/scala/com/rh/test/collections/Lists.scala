package com.rh.test.collections

/**
 * A list is a collection which contains immutable data. List represents linked list in Scala. The Scala List class holds a sequenced, linear list of items.
 * Following are the point of difference between lists and array in Scala:
 *
 * Lists are immutable whereas arrays are mutable in Scala.
 * Lists represents a linked list whereas arrays are flat.
 */
object Lists extends App {

  //List of Strings
  val fruit: List[String] = List("apples", "oranges", "pears")

  //List of Numbers
  val num : List[Int] = List(1, 2, 3)

  //Empty List
  val emptied: List[Nothing] = List()

  //Two dimensional list
  val dim: List[List[Int]] =
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1))

  //Lists can be defined using two fundamental building blocks, a tail "Nil" and cons "::"
  //Nil also represents the empty list. All the above lists can be defined as follows.
  val nilNums = Nil

  val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))

  val numDim = (1 :: (0 :: (0 :: Nil))) ::
               (0 :: (1 :: (0 :: Nil))) ::
               (0 :: (0 :: (1 :: Nil))) :: Nil

  //Basic operations are head, tail, isEmpty
  println("\nThe head of fruit is: " + fruits.head)
  println("\nThe tail of fruit is: " + fruits.tail)
  println("\nThe last of fruit is: " + fruits.last)

  println("\nCheck is fruit empty: " + fruits.isEmpty)
  println("\nCheck is nums empty: " + nilNums.isEmpty)

  //Concatenating Lists
  //You can use either ::: operator or List.:::() method or List.concat() method to add two or more lists.

  val moreFruits = "mangoes" :: ("bananas" :: Nil)
  var allFruits = fruits ::: moreFruits

  println("\nConcatenating lists with ::: operator " + allFruits)

  allFruits = fruits.:::(moreFruits)
  println("\nAdding the elements of a given list in front of this list with the .:::() method " + allFruits)

  allFruits = List.concat(fruits, moreFruits)
  println("\nConcatinating using List.concat method" + allFruits)

  println("\n Reverse all elements of the list: " + allFruits.reverse)

  //Filling Lists
  val filledList = List.fill(3)("apples")
  println("\nUsing List.fill to fill a list 3 times: " + filledList)

  val numFilledList = List.fill(10)(2)
  println("\nUsing List.fill to fill a list of 2's x 10 times: " + numFilledList)

  //Tabulation
  /**
   * method to apply on all the elements of the list before tabulating the list.
   * Its arguments are just like those of List.fill:
   * the first argument list gives the dimensions of the list to create, and the second describes the elements of the list.
   * The only difference is that instead of the elements being fixed, they are computed from a function.
   */
  val squares = List.tabulate(6)(n => n * n)
  println( "\nTabulation of squares : " + squares  )

  val mul = List.tabulate( 4,5 )( _ * _ )
  println( "mul : " + mul  )


}
