from .Product import Product
from Enum.ProductType import ProductType
from .Offer import Offer
class Buy3OnPriceOf2Orange(Offer):
    __offerOnProduct = None 
    def __init__(self, prod:Product):
        self.eligibleProduct = ProductType.ORANGE # static
        self.__offerType = "Buy 3 on price of two Oranges"
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

    def _getPriceItems(self): # float, int
        prod = self._getTargetProduct()
        if (prod._getProductName()==self.eligibleProduct):
            freeCnt = prod._getProductOrigQty()//3
            prod._setProductFreeQty(freeCnt)
            totalQty = prod._getProductOrigQty()
            print(f"Bought Oranges: {prod._getProductOrigQty()}\n")
            price = prod._getProductOrigPrice() * (prod._getProductOrigQty()-prod._getProductFreeQty())
            return (price, totalQty)
        return (0.0, 0)

    def _setProductFreeQty(self, qty:int):
        prod = self._getTargetProduct()
        prod._setProductFreeQty(qty)

    

