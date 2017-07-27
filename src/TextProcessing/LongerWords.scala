package TextProcessing

import java.io._
import java.util._

/**
  * Created by Alex on 7/17/2017.
  */
object LongerWords {
  def main(args: Array[String]): Unit = {
    val input = new Scanner(System.in)
    var in = ""

    println("Lyrics or Poem?:  ")
    in = input.nextLine()
    in = in.toLowerCase()
    println()

    in match{
      case "lyrics" => recieveFile("Flickering Flame.txt")
      case "poem" => recieveFile("The Wicked.txt")
      case default => println("No such file!")
    }
  }

  @throws(classOf[Exception])
  private def recieveFile(link: String): Unit ={
    val file = new FileReader(s"${System.getProperty("user.dir")}${File.separator}Text Documents${File.separator}$link")
    val reader = new BufferedReader((file))
    var line = reader.readLine()
    var text = ""

    while(line != null){
      text += line
      line = reader.readLine()
    }

    val words = text.split(" ")
    val longest = longestWords(words)
    display(longest)
  }

  private def longestWords(list: Array[String]): ArrayList[String] ={
    var mean = 0
    var total = 0
    val longer = new ArrayList[String]

    for(list1: String <- list)
      total += list1.length

    mean = total / list.length

    for(list1: String <- list){
      if(list1.length > mean)
        longer.add(list1)
    }
    longer
  }

  private def display(list: ArrayList[String]): Unit ={
    println("The longer words...\n")

    for(i <- 0 until list.size()){
      print(list.get(i) + " ")
      if((i + 1) % 10 == 0)
        println()
    }
    println()
  }
}
