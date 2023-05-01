class ParkingSlot:
    __counter = 0
    def __init__(self):
        # self.__slot_id = self.__counter
        # self.__num_of_slots = num_of_slots
        self.__isAvailable = True
        # self.__counter += 1
        self.__vehicle = None

    def _reset_counter(self):
        self.__counter = 0

    def _setAvailability(self, availability):
        self.__isAvailable = availability

    def _getAvailability(self)->bool:
        return self.__isAvailable
    
    def _set_slot_id(self, slot_id):
        self.__slot_id = slot_id

    def _get_slot_id(self):
        return self.__slot_id
    
    def _get_vehicle(self):
        return self.__vehicle

    def _get_vehicle_id(self):
        return self._get_vehicle()._get_vehicle_number()
    
    def _increment_counter(self):
        self.__counter += 1

    def _parkVehicle(self, vehicle):
        self.__vehicle = vehicle
        self._setAvailability(False)

    def _unParkVehicle(self):
        self.__vehicle = None
        self._setAvailability(True)

    def _getSlotID(self):
        return self.__slot_id
    

    

    


