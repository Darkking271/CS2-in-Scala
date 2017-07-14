package utilities

import java.awt._

/**
  * Created by Alex on 7/5/2017.
  */
object Random{

  def color(): Color ={
    val rv = number(256)
    val gv = number(256)
    val bv = number(256)
    new Color(rv, gv, bv)
  }

  def point(x: Int, y: Int): String ={
    val a = number(x)
    val b = number(y)
    s"($a, $b)"
  }

  def line(x: Int, y: Int): String = {
    val length = number(x)
    val angle = number(y)
    s"$length $angle"
  }

  private def number(x: Int): Int = (Math.random() * x).toInt
}

class Random{
  val quote: Array[String] = Array[String]("You must be the change you wish to see in the world. -- Mahatma Gandhi",
      "Focus is a matter of deciding what things you're not going to do. -- John Carmack",
      "Injustice anywhere is a threat to justice everywhere. -- Martin Luthor King Jr",
      "Never tell me the odds. -- Han Solo",
      "When I left you, I was but the learner. Now I'm the master. -- Darth Vader",
      "Have no fear of perfection, you'll never reach it -- Salvador Dali",
      "Make your own demons. -- Tony Stark",
      "Winter is coming. -- Ned Stark",
      "I don't want to fix the wheel, I want to break the wheel! -- Daenerys Targaryen",
      "If I say I'm dead, then I am. I'm not going to raise by balding head on a beach in ten\nyears' time, saying all is well. -- Trevor Philips")

  val word: Array[String] = Array[String]("Coffee  ::  Fuel source for programmers and engineers",
      "DOOM  ::  John Carmack's flesh and blood, literally",
      "Python  ::  Computer language for quitters",
      "Guitar  ::  Axe with strings",
      "Router  ::  A friend who never leaves your side",
      "Laptop  ::  The other friend who never leaves",
      "Phone  ::  Brick with lights and buttons",
      "Music  ::  A series of vibrations",
      "Apple  ::  Removing ports because of courage",
      "Netflix  ::  Just one more episode")

  def randQuote(): String = quote(Random.number(10))
  def randWord(): String = word(Random.number(10))
}
