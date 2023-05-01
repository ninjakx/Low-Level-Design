import zope.interface
from enums.VehicleType import VehicleType
import constants.constant as constant

from priceStrategy.pricingInterface import pricingItf

@zope.interface.implementer(pricingItf)
class DefaultPriceStrategy:
    def _get_pricing(self, vehicle_type)->float:
        if vehicle_type == VehicleType.BIKE:
            return constant.BIKE_PRICE
        elif vehicle_type == VehicleType.BICYCLE:
            return constant.BICYCLE_PRICE
        elif vehicle_type == VehicleType.TRUCK:
            return constant.TRUCK_PRICE
        elif vehicle_type == VehicleType.CAR:
            return constant.CAR_PRICE
        else:
            return  constant.UNKNOWN_PRICE
        
        
            
