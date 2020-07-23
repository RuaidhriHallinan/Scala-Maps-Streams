package com.rh.test.basics

/**
 * This example creates the implicit class IntWithTimes.
 * This class wraps an Int value and provides a new method, times.
 * To use this class, just import it into scope and call the times method.
 *
 */

object ImplicitClass {
  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }

      loop(x)
    }
  }
}


