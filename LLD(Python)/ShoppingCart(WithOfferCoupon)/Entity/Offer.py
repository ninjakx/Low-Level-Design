from abc import ABC, abstractmethod
from .Product import Product

class Offer(ABC):
    def __init__(self, prod:Product):
        self.__offerType = None
        self.__offerOnProduct = prod

    @abstractmethod
    def _getTargetProduct(self):
        pass

    @abstractmethod
    def _getProductName(self):
        pass

    @abstractmethod
    def _getProductOrigQty(self):
        pass

    @abstractmethod
    def _setProductFreeQty(self, qty:int):
        pass

    @abstractmethod
    def _getProductFreeQty(self)->int:
        pass

    @abstractmethod
    def _getProductOrigQty(self)->int:
        pass

    @abstractmethod
    def _getProductOrigPrice(self)->float:
        pass
