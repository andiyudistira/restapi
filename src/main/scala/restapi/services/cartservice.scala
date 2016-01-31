package restapi.services

import java.util.{ Date, Calendar, ArrayList }
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation._
import org.springframework.beans.factory.annotation.Autowired

import restapi.entities.{ Cart, Product }
import restapi.repositories.CartRepo
import restapi.util.ServiceResult
import restapi.dto._

@Component
class CartService @Autowired() (private val repo: CartRepo) {

  def submitDiscount(id: Long, discount: Double): ServiceResult = {
    var result = new ServiceResult

    try {
      var cart = repo.findById(id)

      if (cart != null) {
        var i = 0;

        cart.discount = discount
        cart.grandtotal = cart.subtotal - (cart.subtotal * (discount / 100))

        repo.save(cart)

        result.resultData = cart
        result.isSuccess = true
        result.message = "Cart updated"

        result
      } else {
        result.resultData = null
        result.isSuccess = false
        result.message = "Cart does not exist!"

        result
      }
    } catch {
      case e: Exception => {
        result.resultData = null
        result.isSuccess = false
        result.message = "Failed to update cart!"
        result.exception = e.getMessage

        result
      }
    }

    result
  }

  def deleteItemFromCart(cartDto: CartItemDto): ServiceResult = {
    var result = new ServiceResult

    try {
      var cart = repo.findById(cartDto.id)

      if (cart != null) {
        var i = 0;

        for (i <- 1 to cartDto.quantity) {
          cart.subtotal -= cartDto.product.price
          cart.products.remove(convertProductDtoToProduct(cartDto.product))
        }

        cart.grandtotal = cart.subtotal - (cart.subtotal * (cart.discount / 100))

        repo.save(cart)

        result.resultData = cart
        result.isSuccess = true
        result.message = "Cart updated"

        result
      } else {
        result.resultData = null
        result.isSuccess = false
        result.message = "Cart does not exist!"

        result
      }
    } catch {
      case e: Exception => {
        result.resultData = null
        result.isSuccess = false
        result.message = "Failed to update cart!"
        result.exception = e.getMessage

        result
      }
    }

    result
  }

  def addItemToCart(cartDto: CartItemDto): ServiceResult = {
    var result = new ServiceResult

    if (cartDto.id == null) {

      try {
        var cart = convertCartItemDtoToCart(cartDto)

        repo.save(cart)

        result.resultData = cart
        result.isSuccess = true
        result.message = s"Cart saved with id ${cart.id}"

        result

      } catch {
        case e: Exception => {

          result.resultData = null
          result.isSuccess = false
          result.message = "Failed to save cart."
          result.exception = e.printStackTrace.toString()
          result.ex = e
          result
        }
      }
    } else {
      try {
        var cart = repo.findById(cartDto.id)

        if (cart != null) {
          var i = 0;

          for (i <- 1 to cartDto.quantity) {
            cart.subtotal += cartDto.product.price
            cart.products.add(convertProductDtoToProduct(cartDto.product))
          }

          cart.grandtotal = cart.subtotal - (cart.subtotal * (cart.discount / 100))

          repo.save(cart)

          result.resultData = cart
          result.isSuccess = true
          result.message = "Cart updated"

          result
        } else {
          result.resultData = null
          result.isSuccess = false
          result.message = "Cart does not exist!"

          result
        }
      } catch {
        case e: Exception => {
          result.resultData = null
          result.isSuccess = false
          result.message = "Failed to update cart!"
          result.exception = e.getMessage

          result
        }
      }
    }
  }

  private def convertProductDtoToProduct(productdto: ProductDto): Product = {
    var product = new Product
    product.id = productdto.id
    product.name = productdto.name
    product.price = productdto.price
    product.description = productdto.description

    product
  }

  private def convertCartItemDtoToCart(cartdto: CartItemDto): Cart = {
    var crt = new Cart

    crt.CreatedDate = Calendar.getInstance.getTime    
    crt.products = new ArrayList[Product]
    crt.subtotal = 0
    
    var i = 0;

    for (i <- 1 to cartdto.quantity) {
      crt.subtotal += cartdto.product.price
      crt.products.add(convertProductDtoToProduct(cartdto.product))
    }
    crt.grandtotal = crt.subtotal

    crt
  }
}
