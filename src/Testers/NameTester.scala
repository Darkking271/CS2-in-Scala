package Testers

import simplethings.Name

/**
  * Created by Alex on 7/14/2017.
  */
object NameTester {
  def main(args: Array[String]): Unit = {
    val n = new Name("Cleo", "White")
    println(s"First Name = ${n.first}")
    println(s"Last Name = ${n.last}")
    println(s"Natural Name = ${n.natural}")
    println(s"Formal Name = ${n.formal}")

    if(n.check("C", "W"))
      println(s"Initials of ${n.natural} are CW")
    else println(s"Initials of ${n.natural} are not CW")

    if(n.check("W", "C"))
      println(s"Initials of ${n.natural} are WC")
    else println(s"Initials of ${n.natural} are not WC")
  }
}
