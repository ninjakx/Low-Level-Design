# interface will be defined here
import zope.interface
  
class pricingItf(zope.interface.Interface):
    def _get_pricing(self, vehicle_type)->float:
        pass
