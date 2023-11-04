from collections import defaultdict

class TheatreController:
    def __init__(self):
        self.__theatreByCity = defaultdict()
        self.__theatreList = []

    def setTheatreByCity(self, city, theatre):
        if (not self.__theatreByCity.get(city)):
            self.__theatreByCity[city] = [theatre]
        else:
            self.__theatreByCity[city].append(theatre)

    def getTheatreByCity(self, city):
        return self.__theatreByCity[city]

    def getTheatreList(self):
        return self.__theatreList
    
    def setTheatreList(self, theatre):
        self.__theatreList.append(theatre)

    