from collections import OrderedDict

from model.ParkingSlot import ParkingSlot
class SlotController:
    __slot_counter = 0
    def __init__(self):
        self.__slots = []
        pass

    def _get_slot_info(self):
        print("\n=====SLOTS========")
        for slot in self._get_slots():
            print(f"slot ID: {slot._get_slot_id()}, Is Available: {slot._getAvailability()}")

    def _create_slots(self, capacity):
        # reset slots
        self._reset_slots()
        for i in range(capacity):
            ps = ParkingSlot()
            ps._set_slot_id(self.__slot_counter)
            self._increment_counter()
            self._add_slot(ps)

    def _increment_counter(self):
        self.__slot_counter += 1

    def _add_slot(self, slot):
        self.__slots.append(slot)

    def _reset_slots(self):
        self.__slots = []

    def _get_slot_by_id(self, slot_id):
        for slot in self._get_slots():
            if (slot._get_id()==slot_id):
                return slot
        raise Exception("No slots Found !")
    

    def _get_slots(self)->list[ParkingSlot]:
        return self.__slots
    
    def _get_next_available_slot(self)->ParkingSlot:
        for slot in self._get_slots():
            if (slot._getAvailability()==True):
                return slot
        raise Exception("No slots Available !")
    







                


