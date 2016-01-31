package restapi.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._
import org.springframework.beans.factory.annotation.Autowired

import restapi.entities.Product
import restapi.util.ServiceResult
import restapi.services._
import restapi.dto._

/**
 * The REST resource.
 * @param service ProductService
 */
@RestController
class ProductController @Autowired() (private val service: ProductService) {
  
  @RequestMapping(value = Array("/products/save"), method = Array(RequestMethod.POST))
  @ResponseBody
  def saveProduct(@RequestBody product: Product) 
    : ServiceResult = service.SaveProduct(product)

  @RequestMapping(value = Array("/products/delete/{id}"), method = Array(RequestMethod.DELETE))
  @ResponseBody
  def deleteProduct(@PathVariable id: Long) 
    : ServiceResult = service.DeleteProduct(id)    
    
}
