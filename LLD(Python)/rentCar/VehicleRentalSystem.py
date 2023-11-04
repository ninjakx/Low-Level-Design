from Models.Store import Store
from Models.User import User

class VehicleRentalSystem:
    def __init__(self):
        self.__allUsers = []
        self.__allStores = []

    def _addUser(self, user):
        self.__allUsers.append(user)

    def _getAllUsers(self)->list[User]:
        return self.__allUsers

    def _addStore(self, store):
        self.__allStores.append(store)

    def _getAllStores(self)->list[Store]:
        return self.__allStores

    def _getStoreByLocation(self, location):
        for store in self._getAllStores():
            if store._getAddress() == location:
                return store
        return None

    