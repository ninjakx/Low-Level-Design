class Seat:
    def __init__(self):
        self.__seatID = None
        self._seatType = None
        self._rowno = None

    def setSeatID(self, sid):
        self.__seatID = sid

    def getSeatID(self):
        return self.__seatID
    
    def setSeatType(self, stype):
        self._seatType = stype
    
    def getSeatType(self):
        return self._seatType
    
    def setRowno(self, stype):
        self._rowno = stype
    
    def getRowno(self):
        return self._rowno

    
