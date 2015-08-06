package com.dkanev.scala
import math.abs
object TestWorkSheet2 {

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 4)                       //> res0: Int = 144

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4

  def isCloseEnoug(a: Double, b: Double): Boolean = {
    abs((a - b) / a) / a < tolerance
  }                                               //> isCloseEnoug: (a: Double, b: Double)Boolean

  def fixPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      var next = f(guess)
      if (isCloseEnoug(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixPoint: (f: Double => Double)(firstGuess: Double)Double
  
   def squrt(x: Double) = fixPoint(y=> (y+x/y)/2)(1.0)
                                                  //> squrt: (x: Double)Double
   
   squrt(4)                                       //> res1: Double = 2.000000000000002
}