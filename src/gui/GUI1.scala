package gui

import javax.swing._

/**
  * Created by Alex on 7/4/2017.
  */
object GUI1 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI1()
  }

  class GUI1{
    val frame = new JFrame("GUI 1")
    frame.setSize(500, 300)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setVisible(true)
  }
}
