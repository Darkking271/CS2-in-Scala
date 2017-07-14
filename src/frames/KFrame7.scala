package frames

import java.awt._
import java.awt.event._
import javax.swing._
import utilities.Random

/**
  * Created by Alex on 7/5/2017.
  */
class KFrame7(title: String) extends JFrame(title) with ActionListener{
  val reflector = new JPanel()
  val blueButton = new JButton("Blue")
  val redButton = new JButton("Red")
  val greenButton = new JButton("Green")
  val yellowButton = new JButton("Yellow")
  val colorButton = new JButton("Color")
  val input = new JTextField()
  setSize(500, 300)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  addComponents(getContentPane)
  addListeners()
  setVisible(true)


  private def addComponents(contentPane: Container): Unit ={
    val controlPanel = new JPanel()
    controlPanel.setLayout(new FlowLayout())
    controlPanel.add(blueButton)
    controlPanel.add(redButton)
    controlPanel.add(greenButton)
    controlPanel.add(yellowButton)
    controlPanel.add(colorButton)

    contentPane.setLayout(new BorderLayout())
    contentPane.add(controlPanel, BorderLayout.NORTH)
    contentPane.add(reflector, BorderLayout.CENTER)
    contentPane.add(input, BorderLayout.SOUTH)
  }

  private def addListeners(): Unit ={
    blueButton.addActionListener(this)
    redButton.addActionListener(this)
    greenButton.addActionListener(this)
    yellowButton.addActionListener(this)
    colorButton.addActionListener(this)
    input.addActionListener(this)
  }

  override def actionPerformed(event: ActionEvent): Unit ={
    val command = event.getActionCommand
    if (event.getSource.isInstanceOf[JTextField])
      input.setText("")

    command.toUpperCase() match{
      case "RED" => reflector.setBackground(Color.RED)
      case "YELLOW" => reflector.setBackground(Color.YELLOW)
      case "BLUE" => reflector.setBackground(Color.BLUE)
      case "GREEN" => reflector.setBackground(Color.GREEN)
      case "COLOR" => reflector.setBackground(Random.color())
    }
  }
}
