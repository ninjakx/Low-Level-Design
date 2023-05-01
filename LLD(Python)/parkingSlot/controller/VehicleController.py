from collections import OrderedDict

from model.ParkingSlot import ParkingSlot

class VehicleController:
    __vehiclesInSlot = OrderedDict()
    __vehiclesList = []
    def __init__(self):
        pass

    def _get_slot_by_vehicle(self, vehicle):
        return self.__vehiclesInSlot.get(vehicle, None)

    def _assign_vehicle_to_slot(self, vehicle, slot):
        if vehicle not in self.__vehiclesList:
            if (self._get_slot_by_vehicle(slot) is None):
                self.__vehiclesInSlot[vehicle] = slot
                slot._parkVehicle(vehicle)
            else:
                pass
                

            self.__vehiclesList.append(vehicle)

        else:
            raise Exception("Vehicle is already Present in the slot")
        
    def _remove_vehicle(self, vehicle):
        for i, veh in enumerate(self.__vehiclesList):
            if (veh==vehicle):
                del self.__vehiclesList[i]
                break
        
    def _remove_vehicle_from_slot(self, vehicle)->ParkingSlot:
        sl = self.__vehiclesInSlot.get(vehicle, None)
        self._remove_vehicle(vehicle)
        if (sl!=None):
            sl._unParkVehicle()
            return sl
        else:
            raise Exception("Vehicle not found to unpark")
        

        








                


