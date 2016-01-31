package restapi.repositories

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.{RestResource,RepositoryRestResource}
import org.springframework.data.repository.query.Param

import restapi.entities.Product
import restapi.dto._

/**
 * A repository of product entities.
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
trait ProductRepo extends PagingAndSortingRepository[Product, java.lang.Long] {

  // Prevents POST /Products and PATCH /products/:id
  @Override
  @RestResource(exported = false)
  def save(p: Product): Product 

  // Prevents DELETE /Products/:id
  @Override
  @RestResource(exported = false)
  def delete(p: Product)
    
  def findByName(@Param("name") name: String): java.util.List[Product]

  def findByNameStartingWith(@Param("name") name: String): java.util.List[Product]

  def findById(id: java.lang.Long): Product
}
