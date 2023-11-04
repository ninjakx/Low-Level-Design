from models.calendar import Calendar
class MeetingRoom:
    def __init__(self, roomid, loc, capacity):
        self.__id = roomid
        self.__location = loc
        self.__capacity = capacity
        self.__meetings = [] # sorted by date and time
        self.__calendar = Calendar()

    def _get_id(self):
        return self.__id

    def _getCalendar(self):
        return self.__calendar

    def _get_meetings(self):
        return self.__meetings

    def _add_meeting(self, meeting, date)->bool:
        # check for availaibilty
        # look into calendar and all meetings if no overlap then put it
        for cur_meeting in self._getCalendar()._get_meetings_by_date(date):
            # overlapping
            # a       b
            #     c        d
            if cur_meeting._get_start_time()<meeting._get_end_time() and meeting._get_start_time()<cur_meeting._get_end_time():
                return False

        self.__meetings.append(meeting)
        self._getCalendar()._set_meeting_by_date(date, meeting)
        return True

      