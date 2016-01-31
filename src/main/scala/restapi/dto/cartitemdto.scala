package restapi.dto

import java.util.Date
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonFormat

class CartItemDto(i: java.lang.Long, c: Date, a: ProductDto, q: Int) {
  @BeanProperty
  var id: java.lang.Long = i

  @BeanProperty
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  var CreatedDate: Date = c
  
  @BeanProperty
  var product: ProductDto = a
  
  @BeanProperty
  var quantity: Int = q
  
  def this() = this(null, null, null, 0)
}