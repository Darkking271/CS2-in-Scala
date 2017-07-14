package Review

import java.util.Scanner

/**
  * Created by Alex on 7/2/2017.
  */
object LongerWords {
  def main(args: Array[String]): Unit = {
    var input = new Scanner(System.in)

    print("Enter a Sentence:  ")
    var sent = input.nextLine()
    var words = longer(sent)

    println(s"The longer words...\n$words")
  }

  def longer(sent: String): String ={
    var mean = 0
    var total = 0
    var longerWords = ""
    var words = sent.split(" ")

    for (i <- words.indices)
      total += total / words(i).length
    mean = total / words.size

    for (i <- words.indices){
      if (words(i).length > mean)
        longerWords += s"${words(i)}\n"
    }
    longerWords
  }
}
