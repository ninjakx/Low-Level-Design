from .Product import Product
from Enum.ProductType import ProductType
from .Offer import Offer
class Buy1Get1FreeApple(Offer):
    __offerOnProduct = None
    def __init__(self, prod:Product):
        self.eligibleProduct = ProductType.APPLE # static
        self.__offerType = "Buy 1 get 1 free on Apples"
        self.__offerOnProduct = prod

    def _getTargetProduct(self):
        return self.__offerOnProduct

    def _getProductName(self):
        prod = self._getTargetProduct()
        return prod._getProductName()
    
    def _getProductOrigQty(self):
        prod = self._getTargetProduct()
        return prod._getProductOrigQty()

    def _setProductFreeQty(self, qty:int):
        prod = self._getTargetProduct()
        prod._setProductFreeQty(qty)

    def _getProductFreeQty(self)->int:
        prod = self._getTargetProduct()
        return prod._getProductFreeQty()

    def _getProductOrigQty(self)->int:
        prod = self._getTargetProduct()
        return prod._getProductOrigQty()

    def _getProductOrigPrice(self)->float:
        prod = self._getTargetProduct()
        return prod._getProductOrigPrice()

    def _getPriceItems(self)->float:
        prod = self._getTargetProduct()
        if (prod._getProductName()==self.eligibleProduct):
            freeCnt = prod._getProductOrigQty()
            prod._setProductFreeQty(freeCnt)
            totalQty = prod._getProductOrigQty() + prod._getProductFreeQty()
            print(f"Bought Apples: {prod._getProductOrigQty()}, free: {prod._getProductFreeQty()}\n")
            return (prod._getProductOrigPrice() * (prod._getProductOrigQty()), totalQty)
        return (prod._getPriceItems())


    def _setProductFreeQty(self, qty:int):
        prod = self._getTargetProduct()
        prod._setProductFreeQty(qty)