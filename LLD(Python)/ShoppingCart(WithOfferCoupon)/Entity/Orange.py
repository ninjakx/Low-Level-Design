# abstract
from .Product import Product
from Enum.ProductType import ProductType
class Orange(Product):
    def __init__(self):
        self.__productName = ProductType.ORANGE
        self.__productCategory = "Fruits"
        self.__freeQty = 0
        self.__origQty = 0
        self.__origPrice = 10

    def _getProductName(self)->str:
        return self.__productName

    def _getProductCategory(self)->str:
        return self.__productCategory

    def _getProductFreeQty(self)->int:
        return self.__freeQty

    def _getProductOrigQty(self):
        return self.__origQty

    def _getProductOrigPrice(self)->float:
        return self.__origPrice

    def _setProductFreeQty(self, qty:int):
        self.__freeQty = qty

    def _setProductOrigQty(self, qty:int):
        self.__origQty = qty