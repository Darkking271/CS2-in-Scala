package Review

import java.util.Random
/**
  * Created by Alex on 7/2/2017.
  */
object NumberClassification {
  def main(args: Array[String]): Unit = {
    var generator = new Random()
    var all = ""
    var odd = ""
    var even = ""
    var mixed = ""
    var pairs = ""

    var num = generator.nextInt(900) + 100

    for (i <- 1 to 25){
      all += s"$num "
      if (testOdd(num))
        odd += s"$num "
      else if (testEven(num))
        even += s"$num "
      else if (testMixed(num))
        mixed += s"$num "
      else if (testPairs(num))
        pairs += s"$num "

      num = generator.nextInt(900) + 100
    }

    display("The numbers...", all)
    display("The odd digit numbers...", odd)
    display("The even digit numbers...", even)
    display("The mixed digit numbers", mixed)
    display("The pairs...", pairs)
  }

  def testOdd(num: Int): Boolean ={
    val temp = Integer.toString(num)
    val digit = Array.fill[Int](3)(0)

    for (i <- 0 to 2)
      digit(i) = temp(i).toInt

    digit(0) % 2 != 0 && digit(1) % 2 != 0 && digit(2) % 2 != 0
  }

  def testEven(num: Int): Boolean ={
    val temp = Integer.toString(num)
    val digit = Array.fill[Int](3)(0)

    for (i <- 0 to 2)
      digit(i) = temp(i).toInt

    digit(0) % 2 == 0 && digit(1) % 2 == 0 && digit(2) % 2 == 0
  }

  def testMixed(num: Int): Boolean ={
    val temp = Integer.toString(num)
    val digit = Array.fill[Int](3)(0)

    for (i <- 0 to 2)
      digit(i) = temp(i).toInt

    digit(0) != digit(1) && digit(1) != digit(2) && digit(0) != digit(2)
  }

  def testPairs(num: Int): Boolean ={
    val temp = Integer.toString(num)
    val digit = Array.fill[Int](3)(0)

    for (i <- 0 to 2)
      digit(i) = temp(i).toInt

    digit(0) == digit(1) || digit(1) == digit(2) || digit(0) == digit(2)
  }

  def display(text: String, num: String): Unit ={
    println(s"$text \n$num \n")
  }
}
