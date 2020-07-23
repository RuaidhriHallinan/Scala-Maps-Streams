package com.rh.test.maps

import scala.collection.immutable.ListMap

object Maps extends App {

  // Scala map is a collection of key/value pairs (it is similar to dictionary).
  // Any value can be retrieved based on its key.
  // Keys are unique in the Map, but values need not be unique.
  // Maps are also called Hash tables.

  val colors1 = Map(
    "red" -> "#FF0000",
    "azure" -> "#F0FFFF",
    "peru" -> "#CD853F")

  val colors2 = Map(
    "blue" -> "#0033FF",
    "yellow" -> "#FFFF00",
    "red" -> "#FF0000")

  // Creating Array
  val x: Array[Any] = Array(0, 0, 0, 0, 0)

  //Declare Empty Map
  val nums: Map[Int, Int] = Map()

  //Printing Keys and Values
  println("colors1.keys: " + colors1.keys)
  println("colors1.values: " + colors1.values)
  println("colors1.keySet: " + colors1.keySet)

  println("colors1.isEmpty: " + colors1.isEmpty)
  println("nums.isEmpty: " + nums.isEmpty)

  //Concatenating Maps
  val colors = colors1 ++ colors2
  println("\n All colors: " + colors)

  //Printing Keys, foreach map
  colors.foreach { c =>
    println("Keys:" + c._1)
    println("Values:" + c._2)
  }

  //Iterate through and print keys
  colors.keys.foreach { k =>
    print("\nKey = " + k)
    //Find color of key from colors map
    println("Value = " + colors(k))
  }

  println("###############################################")

  // Creation of Map having key-value
  // pairs of type (String, Int)
  val mapMut = scala.collection.mutable.Map[String, Int]()
  println("Empty Map: " + mapMut)

  // Adding new entry
  mapMut += ("Fin" -> 0)
  println("New Entry: " + mapMut)

  println("###############################################")

  //Search map for keys - red
  if(colors.contains("red")) { //Boolean
    println("Red key exists with the code:" + colors("red"))
  } else {
    println("Red does not exist")
  }

  //Search map for keys - red
  if(colors.contains("black")) { //Boolean
    println("black key exists with the code:" + colors("black"))
  } else {
    println("black does not exist")
  }

  //Using exists to check for blue
  val blue_exists =  colors.exists(x => x._1 == "blue")
  println("Does blue exist? " + blue_exists)

  //Updating a value in a mutable map
  val mutableAgeMap = scala.collection.mutable.Map(
    "Grace" -> 1,
    "Ruaidhri" -> 36,
    "Stephanie" -> 34)

  println("\nBefore Updating: " + mutableAgeMap)
  mutableAgeMap("Grace") = 2
  println("After Updating: " + mutableAgeMap)

  //Adding a new k,v pair to the map
  mutableAgeMap += ("Fin" -> 0)

  println("After Adding: " + mutableAgeMap)

  //Removing a k,v pair example
  mutableAgeMap += ("Unknown" -> 100)
  println("After Adding Unknown: " + mutableAgeMap)
  mutableAgeMap -= ("Unknown") //or use mutableAgeMap.-("Unknown")
  println("After Removing Unknown: " + mutableAgeMap)

  mutableAgeMap += ("Unknown" -> 100)
  println("\nAdding Unknown: " + mutableAgeMap)
  //remove() method is utilized to remove a key from the map and return its value only.
  //Must be a mutable map
  mutableAgeMap.remove("Unknown")
  println("\nAfter using Remove: " + mutableAgeMap)

  println("###############################################")

  // Tuple - (k, v) is a tuple with 2 elements
  for((k,v) <- mutableAgeMap) {
    println(s"Key: $k, value: $v ")
  }

  //Copy Map to another Map
  val mutableAgeMap2 = collection.mutable.Map(mutableAgeMap.toSeq: _*)

  //Clone a Map
  val mutableAgeMap3 = mutableAgeMap.clone()
  println("\nCloned map: " + mutableAgeMap3)

  //Map - Iterate through applying a function to all elements of this set
  mutableAgeMap2.map { r =>
    //Example function, changing all values
    mutableAgeMap2(r._1) = r._2 * 100
  }

  println("mapping... mutableAgeMap2(r._1) = r._2 * 100: " + mutableAgeMap2)

  println("###############################################")

  //Using Find method to search value
  val StephsAge = mutableAgeMap.find(_._1 == "Stephanie")
  println("\nStephs age is:" + StephsAge.get._2)
  val StephAgeKey = mutableAgeMap.get("Stephanie")
  println("\nStephs age by Key is:" + StephAgeKey) //Retuens Some
  val StephsAgeApply = mutableAgeMap.apply("Stephanie")
  println("\nStephs age by apply method:" + StephsAgeApply) //Retuens actual Value

  //Apply clear method on a map
  //val cleared = mutableAgeMap.clear()
  // Displays cleared output
  //println(cleared)

  println(mutableAgeMap)

  println("\n###############################################")

  //Sort map by key (name)
  val sortedByKey = ListMap(mutableAgeMap.toSeq.sortBy(_._1) : _*) //This notation tells the compiler to pass each element of arr as its own argument to echo, rather than all of it as a single argument.
  println("sortedByKey: " + sortedByKey)
  val sortedByValue = ListMap(mutableAgeMap.toSeq.sortBy(_._2) : _*) //This notation tells the compiler to pass each element of arr as its own argument to echo, rather than all of it as a single argument.
  println("sortedByValue: " + sortedByValue)

  // reverse map in ascending order
  val ascendingOrder = ListMap(sortedByValue.toSeq.sortWith(_._1 < _._1):_*)
  println("ascendingOrder: " + ascendingOrder)

  // reverse map in descending order
  val descendingOrder = ListMap(sortedByValue.toSeq.sortWith(_._1 > _._1):_*)
  println("descendingOrder: " + descendingOrder)

  // reversing key:value pairs
  val mutableAgeMapRev = mutableAgeMap.clone()
  println("Normal Map : " + mutableAgeMapRev)
  val reversed = for ((k, v) <- mutableAgeMapRev) yield (v, k)
  println("Reversed map : " + reversed)

  println("###############################################")

  println("Get k,v sizes of map: " + mutableAgeMap.size) //The size() method is utilized to find the number of key-value pairs in the stated map.
  println("Get head of map: " + mutableAgeMap.head) //The min() method is utilized to find the first element.
  println("Get tail of map: " + mutableAgeMap.last) //The min() method is utilized to find the last element.
  println("Get min of map: " + mutableAgeMap.min) //The min() method is utilized to find the smallest element of the map.
  println("Get max of map: " + mutableAgeMap.max) //The max() method is utilized to find the biggest element of the map.
  println("Get init of map: " + mutableAgeMap.init) //The init() method selects all elements except the last.
  println("toList method: " + mutableAgeMap.toList) //toList() method is utilized to display the elements of the map in the list.
  println("values method: " + mutableAgeMap.values) //values() method gets all the values from a Scala map as an Iterable.
  println("valuesIterator method: " + mutableAgeMap.valuesIterator) //values() method gets all the values from a Scala map as an Iterator.
  println("mutableAgeMap.count( z => true): " + mutableAgeMap.count( z => true)) // count() method is utilized to count pair of keys in the Map.
  println("toSeq method: " + mutableAgeMap.toSeq) //toSeq() method is utilized to display a sequence ArrayBuffer from the Scala map.
  println("mkString method: " + mutableAgeMap.mkString) //mkString() method is utilized to represent the elements of the map as a string.

  val resArr = mutableAgeMap.toArray
  for ( m <- resArr )
  {
    println("Converted to array[] and printing..." + m )
  }

  val retainedAged = mutableAgeMap.retain((k, v) => v > 30 )
  println("\nRetain method for > 30's: " + retainedAged) //The retain() method is utilized to retain all the pairs of the map that satisfies the stated condition.

  println("###############################################")

  val color1 = scala.collection.immutable.Map(
    "red" -> "#FF0000",
    "azure" -> "#F0FFFF",
    "peru" -> "#CD853F")

  val color2 = scala.collection.immutable.Map(
    "azure" -> "#F0FFFF",
    "peru" -> "#CD853F",
    "red" -> "#FF0000")

  var equalsTest = color1.equals(color2)
  println("equalsTest:" + equalsTest)

  color2 ++ Map("black" -> "XXXXX")
  equalsTest = color1.equals(color2)
  println("equalsTest after change:" + equalsTest)

  println("###############################################")

  var newColors = colors1 ++ colors2
  println("\nNew Colors: " + newColors)
  newColors = newColors.drop(1)
  println("\ndrop(1) Colors: " + newColors)
  newColors = newColors.dropRight(1)
  println("\ndropRight(1) Colors: " + newColors)
  // Applying dropWhile method to delete the elements until the stated condition is satisfied.
  //val result = newColors.dropWhile(z=>false)

  println("###############################################")

  newColors = colors1 ++ colors2
  mutableAgeMap += ("Grace" -> 1)
  mutableAgeMap += ("Finn" -> 0)
  println("\nmutableAgeMap for filtering : " + mutableAgeMap)

  val filterByAge = mutableAgeMap.filter(_._2 > 3)
  println("\nmutableAgeMap filtering > 3: " + filterByAge)
}
