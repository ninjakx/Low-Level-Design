
from enums.VehicleType import VehicleType

class Vehicle:
    __counter = 0
    def __init__(self, vehicle_type):
        self.__vehicle_number = None
        self.__vehicle_type = vehicle_type
        self._set_vehicle_number()

        
    def _get_vehicle_number(self)->str:
        return self.__vehicle_number
    
    def _get_vehicle_type(self)->VehicleType:
        return self.__vehicle_type
    
    def _set_vehicle_number(self)->str:
        self.__vehicle_number = self.__counter
        self.__counter = self.__counter + 1
    
    def _get_vehicle_type(self)->VehicleType:
        return self.__vehicle_type

    