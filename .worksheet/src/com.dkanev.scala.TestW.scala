package com.dkanev.scala

object TestW {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  var chars = List('a', 'b', 'a');System.out.println("""chars  : List[Char] = """ + $show(chars ));$skip(24); val res$0 = 
  chars.groupBy(x => x);System.out.println("""res0: scala.collection.immutable.Map[Char,List[Char]] = """ + $show(res$0));$skip(41); val res$1 = 
  chars.map( x=> (x, chars.count(_==x)));System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(92); val res$2 = 
  chars.groupBy(x => x).map(pair => (pair._1, pair._2.length)).toList.sortWith(_._2 < _._2);System.out.println("""res2: List[(Char, Int)] = """ + $show(res$2))}
}
