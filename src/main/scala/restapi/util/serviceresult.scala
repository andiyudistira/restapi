package restapi.util

import scala.beans.BeanProperty

class ServiceResult {
  //@BeanProperty
  var isSuccess: Boolean = _
  
  @BeanProperty
  var resultData: Object = _
  
  @BeanProperty
  var message: String = _
  
  @BeanProperty
  var exception: String = _
  
  @BeanProperty
  var ex: Exception = _
}