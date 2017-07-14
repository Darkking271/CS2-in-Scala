package gui

import java.awt._
import java.awt.event._
import javax.swing._

/**
  * Created by Alex on 7/4/2017.
  */
object GUI5 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI extends Runnable{
    override def run(): Unit = new GUI5()
  }

  class GUI5{
    val frame = new KFrame("GUI 5")
  }

  class KFrame(title: String) extends JFrame(title) with ActionListener{
    val blueButton = new JButton("Blue")
    val redButton = new JButton("Red")
    val greenButton = new JButton("Green")
    val yellowButton = new JButton("Yellow")
    val reflector = new JPanel()
    setSize(500, 300)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    addComponents(getContentPane)
    addListeners()
    setVisible(true)

    private def addComponents(contentPane: Container): Unit = {
      contentPane.setLayout(new BorderLayout())
      contentPane.add(blueButton, BorderLayout.NORTH)
      contentPane.add(redButton, BorderLayout.SOUTH)
      contentPane.add(greenButton, BorderLayout.EAST)
      contentPane.add(yellowButton, BorderLayout.WEST)
      contentPane.add(reflector, BorderLayout.CENTER)
    }

    private def addListeners(): Unit ={
      blueButton.addActionListener(this)
      redButton.addActionListener(this)
      greenButton.addActionListener(this)
      yellowButton.addActionListener(this)
    }

    override def actionPerformed(event: ActionEvent): Unit ={
      val command = event.getActionCommand
      if (command == "Red")
        reflector.setBackground(Color.RED)
      else if (command == "Yellow")
        reflector.setBackground(Color.YELLOW)
      else if (command == "Blue")
        reflector.setBackground(Color.BLUE)
      else if (command == "Green")
        reflector.setBackground(Color.GREEN)
    }
  }
}
