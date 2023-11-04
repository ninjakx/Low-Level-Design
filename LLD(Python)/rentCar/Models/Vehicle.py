from Enums.VehicleType import VehicleType
from Enums.VehicleStatus import VehicleStatus
class Vehicle:
    def __init__(self):
        self.__mileage = None
        self.__model = None
        self.__totalKm = None
        self.__yearMake = None
        self.__vehicleStatus = None
        self.__vehicleType = None

    def _setModel(self, model):
        self.__model = model

    def _getModel(self)->str:
        return self.__model

    def _setVehicleStatus(self, vehicleStatus):
        self.__vehicleStatus = vehicleStatus

    def _getVehicleStatus(self)->str:
        return self.__vehicleStatus

    def _setVehicleType(self, vehicleType):
        self.__vehicleType = vehicleType

    def _getVehicleType(self)->str:
        return self.__vehicleType


    
    

