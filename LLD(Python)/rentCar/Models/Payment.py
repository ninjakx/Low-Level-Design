from Models.Bill import Bill
class Payment:
    __pid = 0
    def __init__(self):
        self.__paymentID = Payment.__pid
        Payment.__pid = Payment.__pid + 1
        self.__isPaymentCompleted = False
        self.__bill = None

    def _getPaymentID(self):
        return Payment.__pid

    def _checkIsPaymentCompleted(self)->bool:
        return self.__isPaymentCompleted

    def _setIsPaymentCompleted(self, status):
        self.__isPaymentCompleted = status

    def _setBill(self, bill):
        self.__bill = bill

    def _getBill(self)->Bill:
        return self.__bill