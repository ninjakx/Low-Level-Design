package MeetingScheduler;

public class Meeting {
    int start, end;
    Room room;
    public Meeting(int start, int end, Room room){
        this.start = start;
        this.end = end;
        this.room = room;
    }
    public int getStart(){
        return this.start;
    }
    // public void setStart(int start){
    //     this.start = start;
    // }
    public int getEnd(){
        return this.end;
    }
    // public void setEnd(int end){
    //     this.end = end;
    // }
}
