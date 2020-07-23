package com.rh.test.basics

class PointExtending(xc : Int, yc : Int) {

  var x: Int = xc
  println(s"X start at $x")
  var y: Int = yc
  println(s"Y start at $x")

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    println(s"Moved to $x")
    y = y + dy
    println(s"Moved to $y")
  }

}

class Location(xc: Int, yc: Int, zc : Int) extends PointExtending(xc, yc) {

  var z : Int = zc

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    x = x + dx
    y = y + dy
    z = z + dz

    println("Point x location : " + x)
    println("Point y location : " + y)
    println("Point y location : " + y)
  }

}

object ExtendingPoint extends App {
  //val pt = new Point(10, 20)
  //pt.move(10, 10)

  val loc = new Location(10, 20, 15)
  loc.move(10, 10, 5)

}