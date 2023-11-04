from Models.User import User
from Models.Bill import Bill
from Models.Store import Store
from Models.Payment import Payment
from Models.Vehicle import Vehicle
from Models.Reservation import Reservation

from Enums.VehicleStatus import VehicleStatus
from Enums.VehicleType import VehicleType
from VehicleRentalSystem import VehicleRentalSystem

def addUsers()->list[User]:
    user1 = User()
    user1._setDrivingLicense(123456789)

    user2 = User()
    user2._setDrivingLicense(876543)

    return [user1, user2]

def addVehicles():
    vehicle1 = Vehicle()
    vehicle1._setModel("Skoda")
    vehicle1._setVehicleStatus(VehicleStatus.ACTIVE)
    vehicle1._setVehicleType(VehicleType.CAR)

    vehicle2 = Vehicle()
    vehicle2._setModel("Toyota")
    vehicle2._setVehicleStatus(VehicleStatus.ACTIVE)
    vehicle2._setVehicleType(VehicleType.CAR)

    return [vehicle1, vehicle2]

def addStores(vehicles):
    store1 = Store()
    store1._setAddress("Lucknow")
    for vhcl in vehicles[:3]:
        store1._setVehicle(vhcl)
    store2 = Store()
    store2._setAddress("Lucknow")
    for vhcl in vehicles[3:]:
        store1._setVehicle(vhcl)
    return [store1, store2]

if __name__ == "__main__":
    # 1) add User
    users = addUsers()

    # 2) add Vehicle
    vehicles = addVehicles()

    # 3) add Stores
    stores = addStores(vehicles=vehicles)


    rvs = VehicleRentalSystem()
    for store in stores:
        rvs._addStore(store)
    # 4) get stores by place
    place = "Lucknow"
    store = rvs._getStoreByLocation(place)
    if store==None:
        print("error: store not found")
    # print(store._getVehicleInventory()._getAllVehicles())

    vhcl = store._getVehicleInventory()._getAllVehicles()[0]
    reservation = store._createReservation(vhcl, 1234, "Lucknow", "Kanpur", users[0])
    
    bill1 = Bill()
    bill1._setReservation(reservation)

    payment1 = Payment()
    payment1._setBill(bill1)
    payment1._setIsPaymentCompleted(True)

    print(reservation._getVehicle()._getModel())

