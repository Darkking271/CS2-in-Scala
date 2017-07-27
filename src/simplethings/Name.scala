package simplethings

/**
  * Created by Alex on 7/14/2017.
  */
class Name(fn: String, ln: String) extends NameADT{
  val firstName: String = fn
  val lastName: String = ln

  override def first: String = firstName

  override def last: String = lastName

  override def natural: String = s"$firstName $lastName"

  override def formal: String = s"$lastName, $firstName"

  override def toString: String = s"$firstName $lastName"

  override def initials: String = s"${firstName(0)} ${lastName(0)}"

  override def check(fi: String, li: String): Boolean ={
    fi(0) == firstName(0) && li(0) == lastName(0)
  }
}
