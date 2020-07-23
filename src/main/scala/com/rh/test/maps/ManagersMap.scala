package com.rh.test.maps;

/**
 * Problem:
 * Find number of Employees Under every Employee
 * Given a dictionary that contains mapping of employee and his manager as a
 * number of (employee, manager) pairs like below.
 *
 * For example:
 * { "A", "C" },
 * { "B", "C" },
 * { "C", "F" },
 * { "D", "E" },
 * { "E", "F" },
 * { "F", "F" }
 *
 * In this example C is manager of A,
 * C is also manager of B, F is manager  of C and so on.
 *
 * Write a function to get no of employees under each manager in the hierarchy not just their direct reports.
 * It may be assumed that an employee directly reports to only one manager. In the above dictionary the
 * root node/ceo is listed as reporting to himself.
 *
 * Output should be a Dictionary that contains following.
 *
 * A - 0
 * B - 0
 * C - 2
 * D - 0
 * E - 1
 * F - 3
 *
 */

object ManagersMap extends App {

  //Key is the person
  //Value is the manager
  val employees2Managers =
    Map("A" -> "C",
        "B" -> "C",
        "C" -> "F",
        "D" -> "E",
        "E" -> "F",
        "F" -> "F")

  findManagers(employees2Managers)

  def findManagers(e2m : Map[String, String]) : Any = {

    //Group the Map by the value to get a list of the managers
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

  }
}
