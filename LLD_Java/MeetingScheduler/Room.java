package Java.MeetingScheduler;

// import java.util.ArrayList;
// import java.util.List;

// meeting
// booking
public class Room {
    // List<Meeting> meetings;
    String name;
    Calendar calendar;
    Room(String roomName){
        calendar = new Calendar();
        this.name = roomName;
    }
    public boolean book(int start, int end, int day){
        for (Meeting meeting: calendar.getMeeting(day)){
            if (meeting.getStart()<end && start<meeting.getEnd()){
                return false;
            }
        }
        Meeting meet = new Meeting(start, end, this);
        this.calendar.setMeeting(day, meet);
        return true;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
