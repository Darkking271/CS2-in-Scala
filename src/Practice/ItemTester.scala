package Practice

/**
  * Created by Alex on 7/15/2017.
  */
object ItemTester {
  def main(args: Array[String]): Unit = {
    val item1 = new Item("Coffee", 2.15)
    val item2 = new Item("Scone", 1.95)
    val item3 = new Item("Donut", .99)
    println(s"$item1\n$item2\n$item3")

    item1.change(.5)
    println(s"current price of coffe: ${item1.currentPrice}")
    item2.changeSaleStatus(true)
    println(s"current price of scone: ${item2.currentPrice}")
    item3.change(.6)

    println(s"$item1\n$item2\n$item3")
  }
}
