class Show:
    __sid = 0
    def __init__(self):
        self.__showID = self.__sid
        self.__sid += 1
        self.__movie = None
        self.__startTime = None
        self.__endTime = None
        self.__hall = None
        # self.__Duration = None
        self.__bookedSeats = []

    def getShowID(self):
        return self.__ShowID
    
    def setHall(self, hall):
        self.__hall = hall

    def getHall(self):
        return self.__hall

    def setMovie(self, movie):
        self.__movie = movie

    def getMovie(self):
        return self.__movie

    def setStartTime(self, stime):
        self.__startTime = stime

    def getStartTime(self):
        return self.__startTime

    def setEndTime(self, etime):
        self.__endTime = etime

    def getEndTime(self):
        return self.__endTime


    def setBookedSeats(self, seat):
        self.__bookedSeats.append(seat)

    def getBookedSeats(self):
        return self.__bookedSeats

    def getStartTime(self):
        return self.__bookedSeats



