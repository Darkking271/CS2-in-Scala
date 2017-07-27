package trees

import scala.reflect.ClassTag

/**
  * Created by Alex on 7/11/2017.
  */
trait BinaryTreeADT[K, V] {
  def getValue(): V
  def setValue(value: V): Unit
  def empty(): Boolean
  def height(): Int
  def preorder(): Unit
  def inorder(): Unit
  def postorder(): Unit
  @throws(classOf[BinaryTreeCreationException])
  def addLR(key: K, value: V, dir: String): Unit
  def addND(key: K, value: V): Unit
  @throws(classOf[BinaryTreeCreationException])
  def addST(key: K, value: V): Unit
  def get(key: K): V
  def find(key: K): BinaryTreeADT[K, V]
  def member(key: K): Boolean
  def visit(): Unit
  def sprout(key: K, value: V): Unit
}

