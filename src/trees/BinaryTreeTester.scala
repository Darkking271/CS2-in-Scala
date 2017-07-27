package trees

import trees._

/**
  * Created by Alex on 7/13/2017.
  */
object BinaryTreeTester {
  def main(args: Array[String]): Unit = {
    testLR()
    testST()
    testND()
    testND()
  }

  def testLR(): Unit ={
    println("Test LR ...")
    val t = new BinaryTree[String, String]
    println(">>> Creating empty tree.")
    println(">>> Adding elements to the tree directionally ...")
    try {
      t.addLR("lion", null, "")
      t.addLR("shark", null, "r")
      t.addLR("elephant", null, "l")
      t.addLR("zebra", null, "rr")
      t.addLR("alligator", null, "ll")
      t.addLR("ardvaark", null, "llr")
      t.addLR("tiger", null, "rrl")
      t.addLR("giraffe", null, "lr")
      t.addLR("bear", null, "llrr")
      t.addLR("snake", null, "rrll")
    }catch{
      case e: BinaryTreeCreationException => e.printStackTrace()
    }
    println(">>> PREORDER")
    t.preorder()
    println(">>> INORDER")
    t.inorder()
    println(">>> POSTORDER")
    t.postorder()
    println(s">>> HEIGHT = ${t.height()}\n")
  }

  def testST(): Unit ={
    println("Test BST ...")
    val t = new BinaryTree[String, String]
    println(">>> Creating empty tree.")
    println(">>> Adding elements to the binary search tree")
    t.addST("lion", null)
    t.addST("shark", null)
    t.addST("elephant", null)
    t.addST("zebra", null)
    t.addST("alligator", null)
    t.addST("ardvaark", null)
    t.addST("tiger", null)
    t.addST("giraffe", null)
    t.addST("bear", null)
    t.addST("snake", null)
    println(">>> PREORDER")
    t.preorder()
    println(">>> INORDER")
    t.inorder()
    println(">>> POSTORDER")
    t.postorder()
    println(s">>> HEIGHT = ${t.height()}\n")
  }

  def testND(): Unit ={
    println("Test ND ...")
    val t = new BinaryTree[String, String]
    println(">>> Creating empty tree.")
    println(">>> Adding elements to the tree nondeterministically ...")
    t.addND("lion", null)
    t.addND("shark", null)
    t.addND("elephant", null)
    t.addND("zebra", null)
    t.addND("alligator", null)
    t.addND("ardvaark", null)
    t.addND("tiger", null)
    t.addND("giraffe", null)
    t.addND("bear", null)
    t.addND("snake", null)
    println(">>> PREORDER")
    t.preorder()
    println(">>> INORDER")
    t.inorder()
    println(">>> POSTORDER")
    t.postorder()
    println(s">>> HEIGHT = ${t.height()}\n")
  }
}
