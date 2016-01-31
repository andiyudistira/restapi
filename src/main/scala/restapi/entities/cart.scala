package restapi.entities

import java.util.UUID
import javax.persistence._
import scala.beans.BeanProperty
import java.util.Date
import com.fasterxml.jackson.annotation.JsonFormat

/**
 * A cart
 * @param d date created
 * @param g grand total
 * @param c discount
 * @param s sub total
 * @param p product list
 */
@Entity
class Cart(d: Date, g: BigDecimal, s: BigDecimal, c: Double, p: java.util.List[Product]) {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @BeanProperty
  var id: java.lang.Long = _

  @BeanProperty
  @Column(name = "created_date")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  var CreatedDate: Date = d

  @BeanProperty
  @Column(name = "grand_total")
  var grandtotal: BigDecimal = g
  
  @BeanProperty
  @Column(name = "sub_total")
  var subtotal: BigDecimal = s

  @BeanProperty
  @Column(name = "discount")
  var discount: Double = c
  
  @ManyToMany
  @JoinTable(name = "cart_item", joinColumns = Array(new JoinColumn(name="cart_id",referencedColumnName = "id")), inverseJoinColumns = Array(new JoinColumn(name="product_id",referencedColumnName = "id")))
  @BeanProperty
  var products: java.util.List[Product] = _

  def this() = this(null, null, null, 0, null)
}
