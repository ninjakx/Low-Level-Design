package Java.MeetingScheduler;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Calendar {
    public Map<Integer, List<Meeting>> calendar;
    Calendar(){
        this.calendar = new HashMap<Integer, List<Meeting>>();
    }
    public void setMeeting(int day, Meeting meeting){
        List<Meeting> meet = new ArrayList<>();
        meet.add(meeting);
        calendar.put(day, meet);
    }
    public List<Meeting> getMeeting(int day){
        return this.calendar.getOrDefault(day, new ArrayList());
    }
}
