package gui

import frames.KFrame6
import javax.swing.SwingUtilities

/**
  * Created by Alex on 7/5/2017.
  */
object GUI6 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI6()
  }

  class GUI6{
    val frame = new KFrame6("GUI 6")
  }
}
