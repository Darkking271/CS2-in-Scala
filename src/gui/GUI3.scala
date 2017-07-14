package gui

import java.awt._
import javax.swing._

/**
  * Created by Alex on 7/4/2017.
  */
object GUI3 {
  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(new ThreadForGUI())
  }

  private class ThreadForGUI() extends Runnable{
    override def run(): Unit = new GUI3()
  }

  class GUI3(){
    val frame = new KFrame("GUI 3")
  }

  class KFrame(title: String) extends JFrame(title){
    val blueButton = new JButton("Blue")
    val redButton = new JButton("Red")
    val greenButton = new JButton("Green")
    val yellowButton = new JButton("Yellow")
    val colorLabel = new JLabel("Press a button...")
    setSize(500, 300)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    addComponents(getContentPane)
    setVisible(true)

    def addComponents(contentPane: Container): Unit ={
      contentPane.setLayout(new FlowLayout())
      contentPane.add(blueButton)
      contentPane.add(redButton)
      contentPane.add(greenButton)
      contentPane.add(yellowButton)
      contentPane.add(colorLabel)
    }
  }
}
