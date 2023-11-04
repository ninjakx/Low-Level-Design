from Models.Reservation import Reservation
from Models.VehicleInventory import VehicleInventory
class Store:
    __id = 0
    def __init__(self):
        self.__storeid = Store.__id
        Store.__id = Store.__id + 1
        self.__vehicleInventory = VehicleInventory()
        self.__address = None
        self.__allReservations = []

    def _setVehicle(self, vehicle):
        self.__vehicleInventory._addVehicle(vehicle)

    def _getVehicleInventory(self):
        return self.__vehicleInventory
        
    def _getVehicles(self):
        return self.__vehicleInventory._getVehicles()

    def _createReservation(self, vehicle, bookingDate, to, frm, user):
        reserv = Reservation()
        reserv._setBookingDate(bookingDate)
        reserv._setFromLocation(frm)
        reserv._setToLocation(to)
        reserv._setUser(user)
        reserv._setVehicle(vehicle)
        self._addReservation(reserv)
        return reserv

    def _addReservation(self, reservation):
        self.__allReservations.append(reservation)

    def _getReservations(self)->list[Reservation]:
        return self.__allReservations
    
    def _getId(self)->int:
        return self.__storeid

    def _setAddress(self, address):
        self.__address = address

    def _getAddress(self)->str:
        return self.__address

    
