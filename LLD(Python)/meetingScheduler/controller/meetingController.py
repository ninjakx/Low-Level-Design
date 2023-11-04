class MeetingController:
    def __init__(self):
        self.__meetingrooms = []
        # self.__meetings = []
        # self.__meetingsByRoom = defaultdict(list)

    def _add_meeting_rooms(self, meeting_room):
        self.__meetingrooms.append(meeting_room)

    def _get_meeting_rooms(self):
        return self.__meetingrooms


    def _add_meeting(self, meeting, roomid, date):
        for idx, mroom in enumerate(self._get_meeting_rooms()):
            if (mroom._get_id() == roomid):
                if mroom._add_meeting(meeting, date):
                    print(f"Room : {roomid} is booked with the meeting id: {meeting._get_id()}") 
                    return
                else:
                    print(f"Room : {roomid} can't be booked with the meeting id: {meeting._get_id()}") 
                    return 
        print("Room not found")
        

    def _get_meetings_by_room(self, roomid):
        for idx, mroom in enumerate(self._get_meeting_rooms()):
            if (mroom._get_id() == roomid):
                return mroom
        return None
            


    # def _book_meeting(self, meeting):
