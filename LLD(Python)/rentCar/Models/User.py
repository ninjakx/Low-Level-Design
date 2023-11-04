class User:
    __id = 0
    def __init__(self):
        self.__userID = User.__id
        User.__id = User.__id + 1
        self.__drivingLicense = None

    def _setDrivingLicense(self, dl):
        self.__drivingLicense = dl

    def _getDrivingLicense(self):
        return self.__drivingLicense

    def _getUserID(self):
        return self.__userID
  