package TextProcessing

import java.io._
import java.util._
import javax.swing.JFileChooser

import scala.collection.JavaConversions._

/**
  * Created by Alex on 7/25/2017.
  */
object MultiWaySort {
  def main(args: Array[String]): Unit = {
    val words = initialOrder
    val pass1List = pass1(words)
    pass2(pass1List)
  }

  private def initialOrder: ArrayList[String] ={
    val words = getFile
    displayInitialOrder(words)
    words
  }

  private def pass1(words: ArrayList[String]): LinkedList[String] ={
    var vowels = sortVowels(words)
    displayPass1(vowels)
    println()
    val betweenPass = transferQueues(vowels)
    displayList("Words sorted by vowel count: ", betweenPass)
    betweenPass
  }

  private def pass2(pass1List: LinkedList[String]): Unit ={
    var letters = sortLetters(pass1List)
    displayPass2(letters)
    println()
    val finalPass = transferQueues(letters)
    displayList("Words sorted by vowel count and letter count: ", finalPass)
    println("\n")
  }

  @throws (classOf[FileNotFoundException])
  private def getFile: ArrayList[String] ={
    val homedir = s"${System.getProperty("user.dir")}" +
                  s"${File.separator}Text Documents"
    val jfc = new JFileChooser(new File(homedir))
    jfc.showOpenDialog(null)
    val file = jfc.getSelectedFile
    val scanner = new Scanner(file)
    val words = getWords(scanner)
    words
  }

  private def getWords(scanner: Scanner): ArrayList[String] ={
    val words = new ArrayList[String]
    while(scanner.hasNext())
      words.add(scanner.next().toLowerCase())
    words
  }

  private def sortVowels(words: ArrayList[String]): ArrayList[Queue[String]] ={
    val vowels = createEmptyVowelQueues(words)
    for(s <- words){
      vowels.get(vowelCount(s)).add(s.toLowerCase)
    }
    vowels
  }

  private def sortLetters(pass1List: LinkedList[String]): ArrayList[Queue[String]] ={
    val letters = createEmptyLetterQueues(pass1List)
    for(s <- pass1List)
      letters.get(s.length - 1).add(s.toLowerCase())
    letters
  }

  private def transferQueues(words: ArrayList[Queue[String]]): LinkedList[String] ={
    val transferList = new LinkedList[String]
    var copy: Queue[String] = null
    for(i <- words){
      copy = new LinkedList(i)
      for(e <- 0 until copy.size())
        transferList.add(copy.remove())
    }
    transferList
  }

  private def highestVowelCount(words: ArrayList[String]): Int ={
    var most = 0
    var vowel = 0
    var letter: Char = ' '

    for(s <- words){
      vowel = 0
      for(i <- 0 until s.length){
        letter = s.charAt(i).toLower
        if(testVowel(letter))
          vowel += 1
      }
      if(vowel > most)
        most = vowel
    }
    most
  }

  private def highestLetterCount(pass1List: LinkedList[String]): Int ={
    var most = 0
    for(s <- pass1List){
      if(s.length > most)
        most = s.length
    }
    most
  }

  private def vowelCount(s: String): Int ={
    var vowels = 0
    for(i <- 0 until s.length){
      if(testVowel(s.charAt(i).toLower))
        vowels += 1
    }
    vowels
  }

  private def testVowel(i: Char): Boolean = i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u'

  private def createEmptyVowelQueues(words: ArrayList[String]): ArrayList[Queue[String]] ={
    val vowels = new ArrayList[Queue[String]]
    var queue: Queue[String] = null
    for(i <- 0 to highestVowelCount(words)){
      queue = new LinkedList[String]
      vowels.add(queue)
    }
    vowels
  }

  private def createEmptyLetterQueues(pass1List: LinkedList[String]): ArrayList[Queue[String]] ={
    val letters = new ArrayList[Queue[String]]
    var queue: Queue[String] = null
    val count = highestLetterCount(pass1List)
    for(i <- 0 until count){
      queue = new LinkedList[String]
      letters.add(queue)
    }
    letters
  }

  private def displayInitialOrder(words: ArrayList[String]): Unit ={
    println("Initial Order:")
    for(i <- 0 until words.size()){
      print(s"${words.get(i)} ")
      if((i + 1) % 10 == 0)
        println()
    }
    println("\n")
  }

  private def displayPass1(vowels: ArrayList[Queue[String]]): Unit ={
    println("Pass 1:")
    for(i <- 0 until vowels.size()){
      print(s"$i vowels: [")
      displayQueue(vowels.get(i))
      println("]")
    }
  }

  private def displayPass2(letters: ArrayList[Queue[String]]): Unit ={
    println("\n\nPass 2:")
    for(i <- 0 until letters.size()){
      print(s"${i + 1} letters: [")
      displayQueue(letters.get(i))
      println("]")
    }
  }

  private def displayList(text: String, betweenPass: LinkedList[String]): Unit ={
    println(text)
    for(i <- 0 until betweenPass.size()){
      print(s"${betweenPass.get(i)} ")
      if((i + 1) % 10 == 0)
        println
    }
  }

  private def displayQueue(queue: Queue[String]): Unit ={
    val copy: Queue[String] = new LinkedList[String](queue)
    val size = copy.size() - 1
    for(i <- 0 to size){
      print(s"${copy.remove()} ")
      if((i + 1) % 10 == 0 && i != size)
        println
    }
  }
}
