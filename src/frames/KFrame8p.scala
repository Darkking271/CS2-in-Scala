package frames

import java.awt._
import java.awt.event._
import javax.swing._

/**
  * Created by Alex on 7/5/2017.
  */
class KFrame8p(title: String) extends JFrame(title) with ActionListener{
  val output = new JTextArea()
  val pointButton = new JButton("Point")
  val lineButton = new JButton("Line")
  val wordButton = new JButton("Word")
  val quoteButton = new JButton("Quote")
  val colorButton = new JButton("Color")
  val clearButton = new JButton("Clear")
  val input = new JTextField()
  setSize(500, 300)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  addComponents(getContentPane)
  addListeners()
  setVisible(true)

  private def addComponents(contentPane: Container): Unit ={
    val controlPanel = new JPanel()
    controlPanel.setLayout(new FlowLayout())
    controlPanel.add(pointButton)
    controlPanel.add(lineButton)
    controlPanel.add(wordButton)
    controlPanel.add(quoteButton)
    controlPanel.add(colorButton)
    controlPanel.add(clearButton)

    contentPane.setLayout(new BorderLayout())
    contentPane.add(controlPanel, BorderLayout.NORTH)
    contentPane.add(output, BorderLayout.CENTER)
    contentPane.add(input, BorderLayout.SOUTH)
  }

  private def addListeners(): Unit ={
    pointButton.addActionListener(this)
    lineButton.addActionListener(this)
    wordButton.addActionListener(this)
    quoteButton.addActionListener(this)
    colorButton.addActionListener(this)
    clearButton.addActionListener(this)
    input.addActionListener(this)
  }

  override def actionPerformed(event: ActionEvent): Unit = {
    if (event.getSource.isInstanceOf[JTextField])
      input.setText("")

    event.getActionCommand.toUpperCase() match {
      case "POINT" => newLine("POINT")
      case "LINE" => newLine("LINE")
      case "WORD" => newLine("WORD")
      case "QUOTE" => newLine("QUOTE")
      case "COLOR" => newLine("COLOR")
      case "CLEAR" => newLine("CLEAR")
      case "CL" => output.setText("")
    }
  }

  private def newLine(word: String): Unit ={
    output.append(s"$word\n")
  }
}
