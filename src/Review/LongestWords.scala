package Review

import java.util.Scanner

/**
  * Created by Alex on 7/2/2017.
  */
object LongestWords {
  def main(args: Array[String]): Unit = {
    val input = new Scanner(System.in)

    print("Enter a sentence:  ")
    val sent = input.nextLine()
    val word = longest(sent)

    println(word)
  }

  def longest(sent: String): String ={
    var maxLength = 0
    var words = sent.split(" ")
    var longWord = ""

    for (i <- words.indices){
      if (words(i).length > maxLength){
        maxLength = words(i).length
        longWord = words(i)
      }
    }
    longWord
  }
}
