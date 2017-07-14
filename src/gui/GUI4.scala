package gui

import java.awt._
import javax.swing._

/**
  * Created by Alex on 7/4/2017.
  */
object GUI4 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI4()
  }

  class GUI4{
    val gui = new KFrame("GUI 4")
  }

  class KFrame(title: String) extends JFrame(title){
    val blueButton = new JButton("Blue")
    val redButton = new JButton("Red")
    val greenButton = new JButton("Green")
    val yellowButton = new JButton("Yellow")
    val colorLabel = new JLabel("Press a button...", SwingConstants.CENTER)
    setSize(500, 300)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    addComponents(getContentPane)
    setVisible(true)

    def addComponents(contentPane: Container): Unit ={
      contentPane.setLayout(new BorderLayout())
      contentPane.add(blueButton, BorderLayout.NORTH)
      contentPane.add(greenButton, BorderLayout.SOUTH)
      contentPane.add(redButton, BorderLayout.EAST)
      contentPane.add(yellowButton, BorderLayout.WEST)
      contentPane.add(colorLabel, BorderLayout.CENTER)
    }
  }
}
