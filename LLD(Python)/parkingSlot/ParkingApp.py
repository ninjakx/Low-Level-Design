
import sys

from model.Parking import Parking
from model.Vehicle import Vehicle
from enums.VehicleType import VehicleType


def main():

    ps1 = Parking.getInstance(2) # floor number 2
    # ps1._set_capacity(10) # 10 slots allowed
    ps1._create_parking_slot(10)
    ps1._get_slot_details()
    vehicle1 = Vehicle(VehicleType.BIKE)
    ps1._park_vehicle(vehicle1)
    ps1._unPark_vehicle(vehicle1)
    ps1._get_slot_details()

    # ps2 = Parking.getInstance(10) # floor number 2
    # # ps1._set_capacity(5) # 10 slots allowed
    # ps2._create_parking_slot(5)
    # ps2._get_slot_details()
   



if __name__ == "__main__":
    main()

