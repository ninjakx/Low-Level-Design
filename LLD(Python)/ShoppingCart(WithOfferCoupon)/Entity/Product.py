# abstract
from abc import ABC, abstractmethod
class Product(ABC):
    def __init__(self):
        self.__productName = None
        self.__productCategory = None
        self.__freeQty = 0
        self.__origQty = 0
        self.__origPrice = 0.0

    @abstractmethod
    def _getProductName(self)->str:
        pass

    @abstractmethod
    def _getProductCategory(self)->str:
        pass

    @abstractmethod
    def _getProductFreeQty(self)->int:
        pass

    @abstractmethod
    def _getProductOrigQty(self):
        pass

    @abstractmethod
    def _getProductOrigPrice(self)->float:
        pass

    @abstractmethod
    def _setProductFreeQty(self, qty:int):
        pass

    @abstractmethod
    def _setProductOrigQty(self, qty:int):
        pass