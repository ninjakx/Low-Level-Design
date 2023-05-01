import zope.interface
from enums.VehicleType import VehicleType
import constants.constant as constant
import random
from priceStrategy.pricingInterface import pricingItf

def getRandom()->float:
    num = random.randint(1,20)
    return float(num)

@zope.interface.implementer(pricingItf)
class DynamicPriceStrategy:
    def _get_pricing(self, vehicle_type)->float:
        if vehicle_type == VehicleType.BIKE:
            return constant.BIKE_PRICE * getRandom()
        elif vehicle_type == VehicleType.BICYCLE:
            return constant.BICYCLE_PRICE * getRandom()
        elif vehicle_type == VehicleType.TRUCK:
            return constant.TRUCK_PRICE * getRandom()
        elif vehicle_type == VehicleType.CAR:
            return constant.CAR_PRICE * getRandom()
        else:
            return  constant.UNKNOWN_PRICE
        

        
        