class Payment:
    __pid = 0
    def __init__(self):
        self.__paymentID = self.__pid
        self.__pid += 1

    def getPaymentID(self):
        return self.__paymentID