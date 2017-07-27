package TextProcessing

import java.util._
import java.io._
import javax.swing.JFileChooser
import trees._

import scala.collection.JavaConversions._

/**
  * Created by Alex on 7/27/2017.
  */
object TreeFrequencyCounter {
  @throws(classOf[FileNotFoundException])
  def main(args: Array[String]): Unit = {
    val words = getFileWords()
    val tree = createTree(words)
    tree.inorder()
  }

  @throws(classOf[FileNotFoundException])
  private def getFileWords(): ArrayList[String] ={
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
      words.add(scanner.next().toLowerCase)
    words
  }

  private def createTree(words: ArrayList[String]): BinaryTree[String, Int] ={
    val tree = new BinaryTree[String, Int]
    for(s <- words){
      if(tree.member(s)){
        var node = tree.find(s)
        var num = node.getValue() + 1
        node.setValue(num)
      }else
        tree.addST(s, 1)
    }
    tree
  }
}
