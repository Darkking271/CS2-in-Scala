package TextProcessing

import java.util._
import java.io._
import javax.swing.JFileChooser
import scala.collection.JavaConversions._

/**
  * Created by Alex on 7/15/2017.
  */
object HashFrequencyCounter {
  val wordFreq = new HashMap[String, Int]
  val input = new Scanner(System.in)

  @throws(classOf[FileNotFoundException])
  def main(args: Array[String]): Unit = {
    establishFrequencyCounts()
    dump()
    interpret()
  }

  @throws(classOf[FileNotFoundException])
  private def establishFrequencyCounts(): Unit ={
    val words = getFile()
    populateTable(words)
  }

  @throws(classOf[FileNotFoundException])
  private def getFile(): ArrayList[String] ={
    val homedir = s"${System.getProperty("user.dir")}${File.separator}Text Documents"
    val jfc = new JFileChooser(new File(homedir))
    jfc.showOpenDialog(null)
    val file = jfc.getSelectedFile
    val words = getWords(file)
    words
  }

  private def getWords(file: File): ArrayList[String] ={
    val scanner = new Scanner(file)
    val words = new ArrayList[String]
    while(scanner.hasNext)
      words.add(scanner.next.toLowerCase)
    words
  }

  private def populateTable(words: ArrayList[String]): Unit ={
    for(s: String <- words){
      if(wordFreq.containsKey(s))
        wordFreq.put(s, wordFreq.get(s) + 1)
      else
        wordFreq.put(s, 1)
    }
  }

  private def dump(): Unit ={
    println("The Words: ")
    for(key: String <- wordFreq.keySet())
      println(s"<$key: ${wordFreq.get(key)}>")
  }

  private def interpret(): Unit ={
    var option = ""
    println(">>> ")
    option = input.nextLine()
    while(!option.toLowerCase().equals("exit")){
      option.toLowerCase() match{
        case "count" => wordCount()
        case "print" => wordPrint()
        case default => println("No such command")
      }
      println(">>> ")
      option = input.nextLine()
    }
  }

  private def wordCount(): Unit ={
    println("Word?  ")
    val word = input.nextLine()
    if(wordFreq.containsKey(word))
      println(wordFreq.get(word))
    else
      println("Word not found!")
  }

  private def wordPrint(): Unit ={
    val wordSet = new TreeSet[String]
    for(key: String <- wordFreq.keySet())
      wordSet.add(key)
    for(s: String <- wordSet){
      println(s"<$s: ${wordFreq.get(s)}>")
    }
  }
}
