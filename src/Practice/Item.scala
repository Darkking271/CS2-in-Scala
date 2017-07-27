package Practice

/**
  * Created by Alex on 7/15/2017.
  */
class Item(var detail: String, var value: Double) extends ItemADT{
  var sale: Boolean = false

  override def description: String = detail

  override def suggestedRetailPrice: Double = value

  override def onSale: Boolean = sale

  override def currentPrice: Double ={
    if(sale) value *   .7
    else value
  }

  override def change(amount: Double): Unit ={
    value += amount
  }

  override def changeSaleStatus(status: Boolean): Unit ={
    sale = status
  }

  override def toString: String ={
    s"<DESCRIPTION = $detail | SUGGESTED RETAIL PRICE = $value | ON SALE = $sale >"
  }
}
