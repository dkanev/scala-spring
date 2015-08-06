package com.dkanev.scala

object TestW {
  var chars = List('a', 'b', 'b')                 //> chars  : List[Char] = List(a, b, b)
  chars.groupBy(x => x)                           //> res0: scala.collection.immutable.Map[Char,List[Char]] = Map(b -> List(b, b), 
                                                  //| a -> List(a))
  chars.map( x=> (x, chars.count(_==x)))          //> res1: List[(Char, Int)] = List((a,1), (b,2), (b,2))
  chars.groupBy(x => x).map(pair => (pair._1, pair._2.length)).toList.sortWith(_._2 < _._2)
                                                  //> res2: List[(Char, Int)] = List((a,1), (b,2))
}