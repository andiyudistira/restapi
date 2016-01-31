package restapi.entities

import javax.persistence._
import scala.beans.BeanProperty

/**
 * A product
 * @param i id
 * @param n name
 * @param d description
 * @param p price
 * @param c Cart
 */
@Entity
class Product(i: java.lang.Long, n: String, d: String, p: BigDecimal, c: java.util.List[Cart]) {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @BeanProperty
  var id: java.lang.Long = i

  @BeanProperty
  @Column(name = "name", nullable=false, length=20)
  var name: String = n

  @BeanProperty
  @Column(name = "description", nullable=false, length=120)
  var description: String = d

  @BeanProperty
  @Column(name = "price", nullable=false)
  var price: BigDecimal = p

  @BeanProperty
  @ManyToMany(mappedBy = "products")
  var carts: java.util.List[Cart] = _

  def this() = this(null, null, null, null, null)
}
