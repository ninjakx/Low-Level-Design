package MeetingScheduler;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    public List<Room> rooms;
    public Scheduler(){
        rooms = new ArrayList<>();
    }
    public String book(int day, int start, int end) {
        for (Room rms: rooms){
            boolean flag = rms.book(start, end, day);
            if (flag==true){
                return rms.getName();
            }
        }
        return "No room available";
    }
    public void addRoom(Room room){
        this.rooms.add(room);
    }
    public List<Room> getRooms(){
        return this.rooms;
    }
}
