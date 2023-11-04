from collections import defaultdict
class MovieController:
    def __init__(self):
        self.__movieList = []
        self.__moviesByCity = defaultdict()

    def getMovieList(self):
        return self.__movieList
    
    def _setMovieList(self, movie):
        self.__movieList.append(movie)

    def _setMoviesByCity(self, city, movie):
        if city not in self.__moviesByCity:
            self.__moviesByCity[city] = [movie]
        else:
            self.__moviesByCity[city].append(movie)

    def getMoviesByCity(self, city):
        # print([k.getLocation() for k in self.__moviesByCity.keys()])
        # for (k,v) in self.__moviesByCity.items():
        #     print(k.getLocation(), "==>")
        #     for m in v:
        #         print(m.getMovieName())

        # print(city)
        return self.__moviesByCity[city]

    def addMovie(self, city, movie):
        # add movie duration
        self._setMovieList(movie)
        self._setMoviesByCity(city, movie)

    def getMovieByName(self, movieName):
        for movie in self.getMovieList():
            if movie.getMovieName() == movieName:
                return movie
        return None

        
    
    
