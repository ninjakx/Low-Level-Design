import zope.interface
from iPizzaTopping import iPizzaTopping
@zope.interface.implementer(iPizzaTopping)
class ExtraCheeseTopping:
    _cls = None
    def __init__(self, decorator_class):
        self._cls = decorator_class

    # def _getQty(self):
    #     return self._cls._getQty()

    def _getPrice(self):
        return (self._cls._getPrice())+10
    


