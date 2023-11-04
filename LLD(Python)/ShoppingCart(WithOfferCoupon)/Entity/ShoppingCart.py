from collections import OrderedDict
from .Product import Product
from .Buy1Get1FreeApple import Buy1Get1FreeApple
from .Buy3OnPriceOf2Orange import Buy3OnPriceOf2Orange
from Enum.ProductType import ProductType
from .Apple import Apple

class ShoppingCart:
    def __init__(self):
        # self.__prodByName = OrderedDict()
        self.__ListOfProducts = []
        self.__totalPrice = 0
        self.__totalItems = 0

    def _addProduct(self, product:Product):
        self.__ListOfProducts.append(product)

    def _getProductTotalPrice(self)->float:
        return self.__totalPrice

    def _getProductTotalItems(self)->int:
        return self.__totalItems

    def _setProductTotalPrice(self, price:float):
        self.__totalPrice += price

    def _setProductTotalItems(self, items:int):
        self.__totalItems += items

    def _addToCart(self, prod:Product):
        # define coupons here (will be handle internally) 
        # after every addition of the product we will be adding the coupon
        # Buy1Get1FreeApple, Buy3OnPriceOf2Orange
        offerProd = Buy1Get1FreeApple(Buy3OnPriceOf2Orange(prod))
        self._addProduct(offerProd)


    def _getCartDetails(self):
        for offerProd in self.__ListOfProducts:
            total_price, total_items = offerProd._getPriceItems()
            self._setProductTotalPrice(total_price)
            self._setProductTotalItems(total_items)
        print(f"Total Items:{self._getProductTotalItems()}\nTotal Price:{self._getProductTotalPrice()}\n")
        

    



