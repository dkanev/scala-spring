package com.dkanev.scala
import math.abs
object TestWorkSheet2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(242); 

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(100); 
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(92); 

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(29); val res$0 = 

  product(x => x * x)(3, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(26); 

  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(96); 

  def isCloseEnoug(a: Double, b: Double): Boolean = {
    abs((a - b) / a) / a < tolerance
  };System.out.println("""isCloseEnoug: (a: Double, b: Double)Boolean""");$skip(239); 

  def fixPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      var next = f(guess)
      if (isCloseEnoug(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  };System.out.println("""fixPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(58); 
  
   def squrt(x: Double) = fixPoint(y=> (y+x/y)/2)(1.0);System.out.println("""squrt: (x: Double)Double""");$skip(16); val res$1 = 
   
   squrt(4);System.out.println("""res1: Double = """ + $show(res$1))}
}
