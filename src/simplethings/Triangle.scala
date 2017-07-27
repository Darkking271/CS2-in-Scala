package simplethings

/**
  * Created by Alex on 7/14/2017.
  */
class Triangle(side1: Int, side2: Int, side3: Int) extends TriangleADT{
  val sideOne: Double = side1
  val sideTwo: Double = side2
  val sideThree: Double = side3

  def this(sides: Int) = this(sides, sides, sides)

  override def toString: String = s"<Triangle with A = $sideOne" +
                                  s", B = $sideTwo" +
                                  s", C = $sideThree>"

  override def perimeter: Double = sideOne + sideTwo + sideThree

  override def area: Double ={
    val p = (sideOne + sideTwo + sideThree) / 2
    Math.sqrt(p * (p - sideOne) * (p - sideTwo) * (p - sideThree))
  }
}
