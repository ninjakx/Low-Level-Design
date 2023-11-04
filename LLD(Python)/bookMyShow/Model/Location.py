class Location:
    def __init__(self, cityName):
        self.__cityName = cityName

    def getLocation(self):
        return self.__cityName

    # def __repr__(self):
    #     return f'Location({self.getLocation()})'

    def __hash__(self):
        return hash(self.__cityName)

    def __eq__(self, other):
        return self.__cityName == other.__cityName

    def __ne__(self, other):
        # Not strictly necessary, but to avoid having both x==y and x!=y
        # True at the same time
        return not(self == other)

    