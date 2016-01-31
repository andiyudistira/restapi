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
 */
@Controller
class CartController @Autowired() (private val service: CartService) {

  @RequestMapping(value = Array("/carts/additem"), method = Array(RequestMethod.POST))
  @ResponseBody
  def addItem(@RequestBody cart: CartItemDto) 
    : ServiceResult = service.addItemToCart(cart)

  @RequestMapping(value = Array("/carts/deleteitem"), method = Array(RequestMethod.POST))
  @ResponseBody
  def deleteItem(@RequestBody cart: CartItemDto) 
    : ServiceResult = service.deleteItemFromCart(cart)

  @RequestMapping(value = Array("/carts/submitdiscount"), method = Array(RequestMethod.POST))
  @ResponseBody
  def deleteItem(@RequestParam cartid: Long, @RequestParam discount: Double) 
    : ServiceResult = service.submitDiscount(cartid, discount)
}