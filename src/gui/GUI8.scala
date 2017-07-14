package gui

import frames.KFrame8
import javax.swing.SwingUtilities

/**
  * Created by Alex on 7/5/2017.
  */
object GUI8 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI8()
  }

  class GUI8{
    val frame = new KFrame8("GUI 8")
  }
}
