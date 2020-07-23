import scala.collection._

val employees2Managers =
  Map("A" -> "C",
    "B" -> "C",
    "C" -> "F",
    "D" -> "E",
    "E" -> "F",
    "F" -> "F")

//Create a Sequence
val e2m = employees2Managers.toSeq

//Grouping by managers
val e2mGrouped = e2m.groupBy(_._2)

//Sorting the array map by the managers
val e2managers = e2mGrouped.toSeq.sortBy(_._1)

//Creating a new structure of each manager, and size of their team
val res = e2managers.map { r =>
  r._1 -> r._2.size
}

val printMap = res.map {
  println("-------------")
  r =>
    println(r)
}

val printFormattedMap = res.map {
  println("-------------")
  r =>
    println(r._1 + " - " + r._2)
}

val printFormattedSortedMap = res.sortBy(_._2).map {
  println("-------------")
  r =>
    println(r._1 + " - " + r._2)
}
