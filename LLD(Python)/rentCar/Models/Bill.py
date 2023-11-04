from Models.Reservation import Reservation
class Bill:
    __id = 0
    def __init__(self):
        self.__billId = Bill.__id
        Bill.__id = Bill.__id + 1
        self.__reservation = None
        self.__amount = None
        self.__isPaid = False
    
    def _getBillID(self)->int:
        return self.__billId

    def _setAmount(self, amount):
        self.__amount = amount

    def _getAmount(self)->int:
        return self.__amount

    def _setPaidStatus(self, status):
        self.__isPaid = status

    def _getPaidStatus(self)->bool:
        return self.__isPaid

    def _setReservation(self, reservation):
        self.__reservation = reservation

    def _getReservation(self)->Reservation:
        return self.__reservation


