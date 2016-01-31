# RESTApiScala
REST API Backend test for cart management

- Products
Please use this path to manage products: /products
  * adding or updating a products
    Create a http POST req to /products/save with json data in the body and use application/json as the content type
    sample json for adding a product:
    {
      "name": "Product A",
      "description": "product A",
      "price": 2500
    }
    sample json for updating a product (just add id field in the json data):
    {
      "id": 1,
      "name": "Product A",
      "description": "product A updated",
      "price": 2500
    }
  * load products data
    Just go to /products
  * delete products
    Create a http DELETE req to products/delete/{id}

- Cart items
Please use this path to manage cart items: /carts
  * adding or updating a cart items
    Create a http POST req to /carts/additem with json data in the body and use application/json as the content type
    sample json for adding a cart items into a new cart:
    {
        "CreatedDate": "2016-01-31 22:00:00",
        "product": 
        {
            "id": 10,
            "name": "Product B",
            "description": "product B",
            "price": 2500
        },
        "quantity": 2 <-- this will add two products to the carts
    }
    for updating/adding more items to a cart just add the cart id in the json body:
    {
        "id": 20,
        "CreatedDate": "2016-01-31 22:00:00",
        "product": 
        {
            "id": 10,
            "name": "Product B",
            "description": "product B",
            "price": 2500
        },
        "quantity": 2
    }
  * just go to /carts to load carts data
  * removing items from cart
    Create a http POST req to /carts/deleteitem with json data in the body and use application/json as the content type
    You can use the same json data for updating an cart items above
  * submit discount for a cart
    Create a http POST req to /carts/submitdiscount with request param for cart id and discount value in percent
    sample:
    carts/submitdiscount?cartid=20&discount=50 
    The sample above is to add a discount for 50% to cartid 20

    
