package com.rh.test.basics

class Point(xc : Int, yc : Int) {

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

object Demo extends App {
  val pt = new Point(10, 20)
  pt.move(10, 10)

}