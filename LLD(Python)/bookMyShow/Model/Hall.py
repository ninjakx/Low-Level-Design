class Hall:
    __hid = 0
    def __init__(self, name):
        self.__hallName = name
        self.__hallID = self.__hid
        self.__hid += 1
        self.__seats = []

    def setSeats(self, seats):
        self.__seats = seats

    def getSeats(self)->list:
        return self.__seats

    def getHallID(self):
        return self.__hallID

    def getHallName(self):
        return self.__hallName


    
