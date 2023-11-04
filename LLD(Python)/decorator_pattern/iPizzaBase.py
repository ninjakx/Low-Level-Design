import zope.interface
class iPizzaBase(zope.interface.Interface):
    def _getPrice(self)->float:
        pass
    def _getType(self)->str:
        pass
    # def _getQty(self)->int:
    #     pass
    
