package com.dkanev.scala

object inittree {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  val t1 = new NotEmpty(3, new Empty, new Empty);System.out.println("""t1  : com.dkanev.scala.NotEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : com.dkanev.scala.IntSet = """ + $show(t2 ))}
}

abstract class IntSet() {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other:IntSet):IntSet
}

class NotEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  def incl(x: Int): IntSet = {
    if (x < elem) new NotEmpty(elem, left incl x, right)
    else if (x > elem) new NotEmpty(elem, left, right incl x)
    else this
  }

  override def toString(): String = "{" + left + elem + right + "}"
  
    def union(other:IntSet):IntSet = {
      ((left union right) union other) incl elem
  }
}

class Empty() extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NotEmpty(x, new Empty, new Empty)

  override def toString(): String = "."
  def union(other:IntSet):IntSet = other
}
