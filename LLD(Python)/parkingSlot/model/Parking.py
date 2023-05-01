# slot, floor
# different parking for each floor
# entry gates, exit gates
from model.ParkingSlot import ParkingSlot
from controller.VehicleController import VehicleController
from controller.SlotController import SlotController
from priceStrategy.dynamicPricing import DynamicPriceStrategy

class Parking:

    __shared_instances = {}
    __slot_counter = 0
    # Singleton instance
    @staticmethod
    def getInstance(floor_number):
        """Static Access Method"""
        if Parking.__shared_instances.get(floor_number, None) == None:
            instance = Parking(floor_number)
            Parking.__shared_instances[floor_number] = instance
            return instance
        else:
            return Parking.__shared_instances[floor_number]
 
    def __init__(self, floor_number):
        """virtual private constructor"""
        if Parking.__shared_instances.get(floor_number, None) != None:
            raise Exception("This class is a singleton class !")
        else:
            Parking.__shared_instances[floor_number] = self
            self.__floor_number = floor_number
            self.__capacity = 0
            self.__slotcontroller = SlotController()
            self.__vhcontroller = VehicleController()
            self.__pricingStrategy = DynamicPriceStrategy()

    def _get_pricing(self, vehicle_type)->float:
        return self.__pricingStrategy._get_pricing(vehicle_type)

    def _get_floor(self):
        return self.__floor_number
    
    def _set_floor(self, floor_number):
        self.__floor_number = floor_number

    def _set_capacity(self, capacity):
        self.__capacity = capacity

    def _get_capacity(self):
        return self.__capacity
            
    def _park_vehicle(self, vehicle):
        freeSlot = self.__slotcontroller._get_next_available_slot()
        self.__vhcontroller._assign_vehicle_to_slot(vehicle, freeSlot)
        print(f"\nvehicle: {vehicle._get_vehicle_number()} parked at floor number: {self._get_floor()} and slot: {freeSlot._getSlotID()}")

    def _unPark_vehicle(self, vehicle):
        slot = self.__vhcontroller._remove_vehicle_from_slot(vehicle)
        print(f"\nvehicle: {vehicle._get_vehicle_number()} removed at floor number: {self._get_floor()}\nslot: {slot._getSlotID()} is free now\n")
        print(f"Price charged is: {self._get_pricing(vehicle._get_vehicle_type())}")

    def _create_parking_slot(self, capacity):
        self._set_capacity(capacity)
        self.__slotcontroller._create_slots(self._get_capacity())

    def _get_slot_details(self):
        self.__slotcontroller._get_slot_info()

        

            
        





