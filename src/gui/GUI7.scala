package gui

import frames.KFrame7
import javax.swing.SwingUtilities

/**
  * Created by Alex on 7/5/2017.
  */
object GUI7 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI7()
  }

  class GUI7{
    val frame = new KFrame7("GUI 7")
  }
}
