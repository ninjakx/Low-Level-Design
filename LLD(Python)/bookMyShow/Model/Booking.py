class Booking:
    __bid=0
    def __init__(self):
        # for user it is
        # bookedseats
        # show -> movie with hall detail
        self.__show = None
        self.__bookedSeats = []
        self.__bookingID = self.__bid
        self.__bid += 1

        # booking will have payment
        self.__payment = None

    def setShow(self, show):
        self.__show = show

    def getShow(Self):
        return self.__show

    def getBookedSeats(self):
        return self.__bookedSeats
    
    def setBookedSeats(self, bookedSeat):
        self.__bookedSeats.append(bookedSeat)

    def getPayment(self):
        return self.__payment
    
    def setPayment(self, payment):
        self.__payment.append(payment)





