class Meeting:
    __mid = 0
    def __init__(self):
        self.__id =  self.__mid
        Meeting.__mid = Meeting.__mid + 1
        self.__stime = None
        self.__etime = None

    def _get_id(self):
        return self.__id

    def _set_start_time(self, start_time):
        self.__stime = start_time

    def _set_end_time(self, end_time):
        self.__etime = end_time

    def _get_start_time(self):
        return self.__stime

    def _get_end_time(self):
        return self.__etime

    
