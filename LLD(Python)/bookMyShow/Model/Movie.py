class Movie:
    __mid = 0
    def __init__(self):
        self.__movieID = self.__mid
        self.__mid = self.__mid + 1
        self.__movieName = None
        self.__movieDuration = None
        
    def setMovieName(self, name):
        self.__movieName = name

    def getMovieName(self):
        return self.__movieName

    def getMovieID(self):
        return self.__movieID

    def setMovieDuration(self, duration):
        self.__movieDuration = duration

    def getMovieDuration(self):
        return self.__movieDuration




    
        