package restapi.repositories

import java.util.UUID

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.{RestResource,RepositoryRestResource}
import org.springframework.data.repository.query.Param
import java.util.Date

import restapi.entities.Cart

/**
 * A repository of cart entities.
 */
@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
trait CartRepo extends PagingAndSortingRepository[Cart, java.lang.Long] {

  // Prevents POST /carts and PATCH /carts/:id
  @Override
  @RestResource(exported = false)
  def save(c: Cart): Cart 

  // Prevents DELETE /carts/:id
  @Override
  @RestResource(exported = false)
  def delete(p: Cart)
  
  //def findByDate(@Param("CreatedDate") CreatedDate: Date): java.util.List[Cart]

  //def findByNameStartingWith(@Param("name") name: String): java.util.List[Product]

  def findById(id: java.lang.Long): Cart
}
