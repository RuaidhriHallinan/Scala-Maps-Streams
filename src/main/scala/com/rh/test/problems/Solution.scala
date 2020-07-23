package com.rh.test.problems

object Solution extends App {

  val stdin = scala.io.StdIn

  val n = 9

  val ar = Array(10, 20, 20, 10, 10, 30, 50, 10, 20)
  val result = sockMerchant(n, ar)

  System.out.println(result)

  System.out.close()



  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {

    val lala = ar.groupBy(identity).mapValues(_.size)

    lala.size
  }

}