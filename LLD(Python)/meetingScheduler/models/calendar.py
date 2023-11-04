from collections import defaultdict

class Calendar:
    def __init__(self):
        self.__meetingsPerDate = defaultdict()

    def _get_meetings_by_date(self, date): # here date is day: 1->31, assume integer
        return self.__meetingsPerDate.get(date,[])

    def _set_meeting_by_date(self, date, meeting):
       if self.__meetingsPerDate.get(date, [])==[]:
        self.__meetingsPerDate[date] = [meeting]
       else:
        self.__meetingsPerDate[date].append(meeting)
    
