package Practice

import java.io._
import java.util._
import javax.swing.JFileChooser

/**
  * Created by Alex on 7/15/2017.
  */
object FileChooser {
  def main(args: Array[String]): Unit = {
    val homedir = s"${System.getProperty("user.dir")}${File.separator}Text Documents"
    val jfc = new JFileChooser(new File(homedir))
    jfc.showOpenDialog(null)
    val file = jfc.getSelectedFile
    val scanner = new Scanner(file)
    while(scanner.hasNext()){
      println(scanner.next().toLowerCase())
    }
  }
}
