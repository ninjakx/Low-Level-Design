from Model.Location import Location
class Theatre:
    __tid = 0
    def __init__(self):
        self.__theatreID = self.__tid
        self.__tid += 1
        self.__address = None
        # list of screen
        self.__hallList = [] # all the screen
        # list of movies 
        # self.__movieList = [] # all the movies
        self.__city = None
        self.__shows = []

    def getTheatreID(self):
        return self.__theatreID

    def setAddress(self, address):
        self.__address = address

    def getAddress(self)->Location:
        return self.__address

    def setShows(self, shows):
        self.__shows.append(shows)

    def getShows(self):
        return self.__shows

    def setHalls(self, hall):
        self.__hallList.append(hall)

    def getHalls(self):
        return self.__hallList

    # def setMovieList(self, movie):
    #     self.__movieList.append(movie)

    # def getMovieList(self):
    #     return self.__movieList
    
    def setCity(self, city):
        self.__city = city

    def getCity(self)->Location:
        return self.__city

    
