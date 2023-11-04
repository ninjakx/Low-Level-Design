from Entity.Apple import Apple
from Entity.Orange import Orange
from Entity.ShoppingCart import ShoppingCart
from Enum.ProductType import ProductType

if __name__ == "__main__":
    p1 = Apple()
    p1._setProductOrigQty(2)

    p2 = Orange()
    p2._setProductOrigQty(6)

    cart = ShoppingCart()
    cart._addToCart(p1)
    cart._addToCart(p2)

    cart._getCartDetails()


