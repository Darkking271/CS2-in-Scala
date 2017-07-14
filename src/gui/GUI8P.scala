package gui

import frames.KFrame8p
import javax.swing.SwingUtilities

/**
  * Created by Alex on 7/5/2017.
  */
object GUI8P {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI8P()
  }

  class GUI8P{
    val frame = new KFrame8p("GUI 8P")
  }
}
