package Review

import java.util.Scanner

/**
  * Created by Alex on 7/2/2017.
  */
object CollatzSequence {
  def main(args: Array[String]): Unit = {
    val input = new Scanner(System.in)
    var count = 0

    print("The positive integer?  ")
    var num = input.nextInt()
    print(s"$num ")

    while (num != 1){
      if (num % 2 == 0){
        num /= 2
        print(s"$num ")
        count = format(count)
      }else{
        num = num * 3 + 1
        print(s"$num ")
        count = format(count)
      }
    }
  }

  private def format(count: Int): Int ={
    val num = count + 1
    if ((num + 1) % 10 == 0)
      println()
    num
  }
}
