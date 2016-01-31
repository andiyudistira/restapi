package restapi.dto

import scala.beans.BeanProperty

class ProductDto(i: java.lang.Long, n: String, d: String, p: BigDecimal) {  
  @BeanProperty
  var id: java.lang.Long = i

  @BeanProperty  
  var name: String = n

  @BeanProperty
  var description: String = d

  @BeanProperty
  var price: BigDecimal = p
  
  def this() = this(null, null, null, null)
}