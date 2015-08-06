package com.dkanev.scala

object TestW {
  var chars = List('a', 'b', 'a')                 //> chars  : List[Char] = List(a, b, a)
  chars.groupBy(x => x)                           //> res0: scala.collection.immutable.Map[Char,List[Char]] = Map(b -> List(b), a -
                                                  //| > List(a, a))
  chars.map( x=> (x, chars.count(_==x)))          //> res1: List[(Char, Int)] = List((a,2), (b,1), (a,2))
  chars.groupBy(x => x).map(pair => (pair._1, pair._2.length)).toList.sortWith(_._2 < _._2)
                                                  //> res2: List[(Char, Int)] = List((b,1), (a,2))
}