import zope.interface
from iPizzaBase import iPizzaBase
@zope.interface.implementer(iPizzaBase)
class VegDelightPizzaBase:
    def _getPrice(self)->float:
        return 10.0
    def _getQty(self)->int:
        return 3
    def _getType(self)->str:
        return 'veg delight' 

    