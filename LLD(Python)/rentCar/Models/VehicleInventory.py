from Models.Vehicle import Vehicle

class VehicleInventory:
    def __init__(self):
        self.__allVehicles = []

    def _getAllVehicles(self)->list[Vehicle]:
        return self.__allVehicles

    def _addVehicle(self, vehicle):
        self.__allVehicles.append(vehicle)

