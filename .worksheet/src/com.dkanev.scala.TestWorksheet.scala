package com.dkanev.scala

object TestWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
   def cube(x:Int):Int  = x*x*x;System.out.println("""cube: (x: Int)Int""");$skip(73); 
   def sumInt(a:Int, b:Int):Int =
      if(a>b) 0 else a + sumInt(a+1,b);System.out.println("""sumInt: (a: Int, b: Int)Int""");$skip(94); 
  
  def sum(f:Int=> Int,a:Int, b:Int):Int = {
      if(a>b) 0 else f(a) + sum(f, a +1,b)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(144); 
  
  def sumFunction(f:Int=>Int) : (Int,Int) => Int = {
    def sumF(a:Int, b:Int):Int =
      if(a>b) 0 else f(a) + sumF(a +1,b)
     sumF
  };System.out.println("""sumFunction: (f: Int => Int)(Int, Int) => Int""");$skip(96); 
  
  def sum2(f:Int=> Int)(a:Int,b:Int):Int = {
      if(a>b) 0 else f(a) + sum2(f)(a +1,b)
  };System.out.println("""sum2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(47); 
  
  def sumCubes = sumFunction(x => x* x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(53); 
  
  def fact(x:Int):Int = if(x==0) 1 else fact(x-1);System.out.println("""fact: (x: Int)Int""");$skip(55); 
  
  def sumFactoriel(a:Int,b:Int):Int = sum(fact,a,b);System.out.println("""sumFactoriel: (a: Int, b: Int)Int""");$skip(39); 
  def sumFactoriel2= sumFunction(fact);System.out.println("""sumFactoriel2: => (Int, Int) => Int""");$skip(24); val res$0 = 
  
  sumFactoriel(1,8);System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
  sumFactoriel2(1,8);System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 
  sumInt(1,3);System.out.println("""res2: Int = """ + $show(res$2));$skip(16); val res$3 = 
  sumCubes(2,2);System.out.println("""res3: Int = """ + $show(res$3));$skip(187); 
  
  def sumlTail(f:Int=> Int,a:Int, b:Int):Int = {
      def loop(a: Int, acc: Int): Int = {
          if (a>b) acc
          else loop(a+1, f(a) + acc)
        }
        loop(a, 0)
  };System.out.println("""sumlTail: (f: Int => Int, a: Int, b: Int)Int""");$skip(26); 

  def id(x:Int) :Int = x;System.out.println("""id: (x: Int)Int""");$skip(37); 
  def sumInteger = sumFunction(x=>x);System.out.println("""sumInteger: => (Int, Int) => Int""");$skip(49); 
  def sumIn(a:Int,b:Int) = sumlTail(x => x, a,b);System.out.println("""sumIn: (a: Int, b: Int)Int""");$skip(18); val res$4 = 
  sumInteger(1,3);System.out.println("""res4: Int = """ + $show(res$4));$skip(18); val res$5 = 
  sumInteger(1,3);System.out.println("""res5: Int = """ + $show(res$5));$skip(27); val res$6 = 
  sumFunction( x=> x)(1,3);System.out.println("""res6: Int = """ + $show(res$6));$skip(20); val res$7 = 
  sum2( x=> x)(1,3);System.out.println("""res7: Int = """ + $show(res$7));$skip(94); 
  def product(f:Int=>Int)(a:Int,b:Int):Int ={
     if(a>b) 1 else f(a)* product(f)(a+1,b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(26); val res$8 = 
  
  product(x=>x*x)(3,4);System.out.println("""res8: Int = """ + $show(res$8));$skip(104); 
  
    def factoriel(f:Int=>Int)(a:Int,b:Int):Int ={
     if(a>b) 0 else f(a) + factoriel(f)(a+1,b)
  };System.out.println("""factoriel: (f: Int => Int)(a: Int, b: Int)Int""");$skip(26); val res$9 = 
  
  factoriel(fact)(1,8);System.out.println("""res9: Int = """ + $show(res$9));$skip(42); 
  
  def fact1(n:Int)= product(x=>x)(1,n);System.out.println("""fact1: (n: Int)Int""");$skip(11); val res$10 = 
  fact1(3);System.out.println("""res10: Int = """ + $show(res$10))}
 
  
}
