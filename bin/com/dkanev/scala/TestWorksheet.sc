package com.dkanev.scala

object TestWorksheet {
   def cube(x:Int):Int  = x*x*x                   //> cube: (x: Int)Int
   def sumInt(a:Int, b:Int):Int =
      if(a>b) 0 else a + sumInt(a+1,b)            //> sumInt: (a: Int, b: Int)Int
  
  def sum(f:Int=> Int,a:Int, b:Int):Int = {
      if(a>b) 0 else f(a) + sum(f, a +1,b)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  def sumFunction(f:Int=>Int) : (Int,Int) => Int = {
    def sumF(a:Int, b:Int):Int =
      if(a>b) 0 else f(a) + sumF(a +1,b)
     sumF
  }                                               //> sumFunction: (f: Int => Int)(Int, Int) => Int
  
  def sum2(f:Int=> Int)(a:Int,b:Int):Int = {
      if(a>b) 0 else f(a) + sum2(f)(a +1,b)
  }                                               //> sum2: (f: Int => Int)(a: Int, b: Int)Int
  
  def sumCubes = sumFunction(x => x* x * x)       //> sumCubes: => (Int, Int) => Int
  
  def fact(x:Int):Int = if(x==0) 1 else fact(x-1) //> fact: (x: Int)Int
  
  def sumFactoriel(a:Int,b:Int):Int = sum(fact,a,b)
                                                  //> sumFactoriel: (a: Int, b: Int)Int
  def sumFactoriel2= sumFunction(fact)            //> sumFactoriel2: => (Int, Int) => Int
  
  sumFactoriel(1,8)                               //> res0: Int = 8
  sumFactoriel2(1,8)                              //> res1: Int = 8
  sumInt(1,3)                                     //> res2: Int = 6
  sumCubes(2,2)                                   //> res3: Int = 8
  
  def sumlTail(f:Int=> Int,a:Int, b:Int):Int = {
      def loop(a: Int, acc: Int): Int = {
          if (a>b) acc
          else loop(a+1, f(a) + acc)
        }
        loop(a, 0)
  }                                               //> sumlTail: (f: Int => Int, a: Int, b: Int)Int

  def id(x:Int) :Int = x                          //> id: (x: Int)Int
  def sumInteger = sumFunction(x=>x)              //> sumInteger: => (Int, Int) => Int
  def sumIn(a:Int,b:Int) = sumlTail(x => x, a,b)  //> sumIn: (a: Int, b: Int)Int
  sumInteger(1,3)                                 //> res4: Int = 6
  sumInteger(1,3)                                 //> res5: Int = 6
  sumFunction( x=> x)(1,3)                        //> res6: Int = 6
  sum2( x=> x)(1,3)                               //> res7: Int = 6
  def product(f:Int=>Int)(a:Int,b:Int):Int ={
     if(a>b) 1 else f(a)* product(f)(a+1,b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x=>x*x)(3,4)                            //> res8: Int = 144
  
    def factoriel(f:Int=>Int)(a:Int,b:Int):Int ={
     if(a>b) 0 else f(a) + factoriel(f)(a+1,b)
  }                                               //> factoriel: (f: Int => Int)(a: Int, b: Int)Int
  
  factoriel(fact)(1,8)                            //> res9: Int = 8
  
  def fact1(n:Int)= product(x=>x)(1,n)            //> fact1: (n: Int)Int
  fact1(3)                                        //> res10: Int = 6
 
  
}