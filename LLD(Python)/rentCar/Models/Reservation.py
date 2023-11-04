from Models.User import User
from Models.Vehicle import Vehicle
class Reservation:
    __id = 0
    def __init__(self):
        self.__reservationId = Reservation.__id
        Reservation.__id = Reservation.__id + 1
        self.__vehicle = None
        self.__bookingDate = None
        self.__toLocation = None
        self.__fromLocation = None
        self.__user = None

    def _setVehicle(self, vehicle):
        self.__vehicle = vehicle

    def _getVehicle(self)->Vehicle:
        return self.__vehicle

    def _getReservationID(self)->int:
        return self.__reservationId

    def _setBookingDate(self, bookingDate):
        self.__bookingDate = bookingDate

    def _getBookingDate(self)->int:
        return self.__bookingDate

    def _setToLocation(self, toLocation):
        self.__toLocation = toLocation

    def _setFromLocation(self, fromLocation):
        self.__fromLocation = fromLocation

    def _getFromLocation(self)->int:
        return self.__fromLocation

    def _getToLocation(self)->int:
        return self.__toLocation

    def _setUser(self, user):
        self.__user = user

    def _getUser(self)->User:
        return self.__user


    

