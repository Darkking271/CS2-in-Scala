package gui

import javax.swing._

/**
  * Created by Alex on 7/4/2017.
  */
object GUI2 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI2()
  }

  class GUI2{
    val frame = new KFrame("GUI 2")

    class KFrame(title: String) extends JFrame(title){
      setSize(500, 300)
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
      this.setVisible(true)
    }
  }
}
