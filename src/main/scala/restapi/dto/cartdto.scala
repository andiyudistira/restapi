package restapi.dto

import java.util.Date
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonFormat

class CartDto(i: java.lang.Long, c: Date, g: BigDecimal, s: BigDecimal, d: Double, l: java.util.List[ProductDto]) {
  @BeanProperty
  var id: java.lang.Long = i

  @BeanProperty
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  var CreatedDate: Date = c

  @BeanProperty
  var grandtotal: BigDecimal = g
  
  @BeanProperty
  var subtotal: BigDecimal = s

  @BeanProperty
  var discount: Double = d
  
  @BeanProperty
  var products: java.util.List[ProductDto] = l
  
  def this() = this(null, null, null, null, 0, null)
}