package com.rh.test.problems

object Fibonacci extends App {

  def calcFib(n: Int): Int = n match {
    case 0 | 1 => n
    case _ => calcFib(n-1) + calcFib(n-2)
  }

  val fibToTwenty = calcFib(20)
  println(s"Fibonacci sequence to 20 is: $fibToTwenty")

}
