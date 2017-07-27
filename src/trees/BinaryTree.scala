package trees

/**
  * Created by Alex on 7/13/2017.
  */
class BinaryTree[K, V] extends BinaryTreeADT[K, V]{
  private var key: K = _
  private var value: V = _
  private var lchild: BinaryTree[K, V] = _
  private var rchild: BinaryTreeADT[K, V] = _

  override def getValue(): V = value

  override def setValue(value: V): Unit ={this.value = value}

  override def empty(): Boolean = this.key == null

  override def height(): Int ={
    if(empty()) 0
    else 1 + max(lchild.height(), rchild.height())
  }

  private def max(a: Int, b: Int): Int ={
    if (a > b) a
    else b
  }

  override def preorder(): Unit ={
    if (!empty()){
      visit()
      lchild.preorder()
      rchild.preorder()
    }
  }

  override def inorder(): Unit ={
    if (!empty()){
      lchild.inorder()
      visit()
      rchild.inorder()
    }
  }

  override def postorder(): Unit ={
    if(!empty()){
      lchild.postorder()
      rchild.postorder()
      visit()
    }
  }

  @throws(classOf[BinaryTreeCreationException])
  override def addLR(key: K, value: V, dir: String): Unit ={
    try {
      if (dir == "")
        sprout(key, value)
      else if (dir(0).toUpper == 'L')
        lchild.addLR(key, value, dir.substring(1))
      else if (dir(0).toUpper == 'R')
        rchild.addLR(key, value, dir.substring(1))
      else throw new BinaryTreeCreationException(s"### strange directional indicator: ${dir(0)}")
    }catch{
      case tree: BinaryTreeCreationException => throw new BinaryTreeCreationException("### no such location in tree")
    }
  }

  override def addND(key: K, value: V): Unit ={
    if(empty())
      sprout(key, value)
    else if (Math.random() < .5)
      lchild.addND(key, value)
    else rchild.addND(key, value)
  }

  override def addST(key: K, value: V): Unit ={
    if(empty())
      sprout(key, value)
    else{
      val cey = key.asInstanceOf[Comparable[K]]
      val t = this.key.asInstanceOf[Comparable[K]]
      if(cey.compareTo(t.asInstanceOf[K]: K) < 0)
        lchild.addST(key, value)
      else if (cey.compareTo(t.asInstanceOf[K]: K) > 0)
        rchild.addST(key, value)
      else throw new BinaryTreeCreationException("### can't have equality in bst")
    }
  }

  override def get(key: K): V ={
    find(key).getValue()
  }

  override def find(key: K): BinaryTreeADT[K, V] ={
    if(empty()) null
    else if(this.key == key) this
    else{
      val l = lchild.find(key)
      if(l != null) return l
      val r = rchild.find(key)
      if(r != null) return r
      null
    }
  }

  override def member(key: K): Boolean ={
    if(empty()) return false
    else if(this.key == key) return true
    else return (lchild.member(key) || rchild.member(key))
  }

  override def visit(): Unit ={
    var rep = ""
    if(value == null)
      rep = "---"
    else
      rep = value.toString
    println(s"[$key:$rep]")
  }

  override def sprout(key: K, value: V): Unit ={
    this.key = key
    this.value = value
    this.lchild = new BinaryTree[K, V]()
    this.rchild = new BinaryTree[K, V]()
  }
}
