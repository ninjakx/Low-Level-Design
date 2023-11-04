# // meeting
# // calendar -> dates , time -> meeting, duration
# // meeting -> room, duration, date, time, booked by
# // room -> list of all the bookings by date
# // room controller -> add booking to the room, 
# // meeting scheduler -> service -> book->add/remove if available during that time (no overlap)
# also will keep history
# Requirements:
# There are n given meeting rooms available
# Book a meeting in any meeting room at given interval(starting time, end time, capacity)
# - send notification to all the person who are invited for meeting
# - use calendar for tracking date and TimeoutError
# - capacity in rooms
# - also history of all the meetings which are booked and meeting room

from controller.meetingController import MeetingController
from models.meeting import Meeting
from models.meetingRoom import MeetingRoom

if __name__ == '__main__':
    meetingController = MeetingController()
    meetingRoom1 = MeetingRoom(1, "loc1", 10)
    meetingController._add_meeting_rooms(meetingRoom1)
    meetingRoom2 = MeetingRoom(2, "loc2", 4)
    meetingController._add_meeting_rooms(meetingRoom2)
    meetingRoom3 = MeetingRoom(3, "loc3", 5)
    meetingController._add_meeting_rooms(meetingRoom3)
    # print(meetingController._get_meeting_rooms())
    meeting1 = Meeting()
    meeting1._set_start_time(10)
    meeting1._set_end_time(20)
    meetingController._add_meeting(meeting1, 1, 20) # 20th of the month
    meeting2 = Meeting()
    meeting2._set_start_time(20)
    meeting2._set_end_time(30)
    meetingController._add_meeting(meeting2, 1, 20) # 20th of the month
    meeting3 = Meeting()
    meeting3._set_start_time(5)
    meeting3._set_end_time(15)
    meetingController._add_meeting(meeting3, 1, 20) # 20th of the month
    # throws an error when room is not found
    try:
        for meeting in (meetingController._get_meetings_by_room(10)._get_meetings()):
            print(meeting._get_id())
    except Exception as e:
        print("Room not found")





    


