package Testers

import simplethings.Triangle

/**
  * Created by Alex on 7/14/2017.
  */
object TriangleTester {
  def main(args: Array[String]): Unit = {
    val edward = new Triangle(10)
    println(edward.toString)

    val iris = new Triangle(3, 4, 5)
    println(iris.toString)

    println(s"Perimeter of equilateral = ${edward.perimeter}")
    println(s"Perimeter of iris = ${iris.perimeter}")
    println(s"Area of equilateral = ${edward.area}")
    println(s"Area of iris = ${iris.area}")
  }
}
