package BookMyShow.Theatre;
import BookMyShow.Model.*;
public class Seat {
    int seatID;
    int rowNum;
    SeatType seatType;
    public int getSeatID(){
        return seatID;
    }
    public void setSeatID(int seatID){
        this.seatID = seatID;
    }
    public int getRowNum(){
        return rowNum;
    }
    public void setRowNum(int rowNum){
        this.rowNum = rowNum;
    }
    public SeatType getSeatType(){
        return seatType;
    }
    public void setSeatType(SeatType seatType){
        this.seatType = seatType;
    }
}

