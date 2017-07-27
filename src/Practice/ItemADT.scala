package Practice

/**
  * Created by Alex on 7/15/2017.
  */
trait ItemADT {
  def description: String
  def suggestedRetailPrice: Double
  def onSale: Boolean
  def currentPrice: Double
  def change(amount: Double): Unit
  def changeSaleStatus(status: Boolean): Unit
  def toString: String
}
