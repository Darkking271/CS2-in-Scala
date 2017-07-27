package simplethings

/**
  * Created by Alex on 7/14/2017.
  */
trait NameADT {
  def first(): String
  def last: String
  def natural: String
  def formal: String
  def toString: String
  def initials: String
  def check(fi: String, li: String): Boolean
}
