package restapi.services

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation._
import org.springframework.beans.factory.annotation.Autowired

import restapi.entities.Product
import restapi.repositories.ProductRepo
import restapi.util.ServiceResult
import restapi.dto._

import org.hibernate.exception._

@Component
class ProductService @Autowired() (private val repo: ProductRepo) {
  def SaveProduct(product: Product): ServiceResult = {
    val result = new ServiceResult
    
    try {
      repo.save(product)

      val productResult = new ProductDto(product.id, product.name, product.description, product.price)

      result.resultData = productResult
      result.isSuccess = true
      result.message = s"Saved Product: ${product.name} with ID: ${product.id}!"

    } catch {
      case e: Exception => {
        result.resultData = null
        result.isSuccess = false
        result.message = s"Save Product: ${product.name} failed!"
        result.exception = e.getMessage
      }
    }

    result
  }

  def DeleteProduct(id: Long): ServiceResult = {
    val result = new ServiceResult

    try {
      repo.delete(id)

      //val productResult = new ProductDto(product.id, product.name, product.description, product.price)

      result.resultData = null
      result.isSuccess = true
      result.message = s"Deleted Product ID: ${id}!"

    } catch {
      case e: Exception => {
        result.resultData = null
        result.isSuccess = false
        result.message = s"Delete Product ID: ${id} failed!"
        result.exception = e.getMessage
      }
    }

    result
  }
}