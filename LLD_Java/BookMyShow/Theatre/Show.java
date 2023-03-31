package BookMyShow.Theatre;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
// import BookMyShow.Model.*;
import BookMyShow.Movie.Movie;
public class Show {
    int showID;
    Movie movie;
    int fromTimeStamp;
    int toTimeStamp;
    Date showDate;
    Screen screen;

    List<Integer> bookedSeatIds = new ArrayList<>();
    public int getShowID(){
        return showID;
    }
    public void setShowID(int showID){
        this.showID = showID;
    }
    public Movie getMovie(){
        return movie;
    }
    public void setMovie(Movie movie){
        this.movie = movie;
    }
    public int getFromTimeStamp(){
        return fromTimeStamp;
    }
    public void setFromTimeStamp(int fromTimeStamp){
        this.fromTimeStamp = fromTimeStamp;
    }
    public int getToTimeStamp(){
        return toTimeStamp;
    }
    public void setToTimeStamp(int toTimeStamp){
        this.toTimeStamp = toTimeStamp;
    }
    public Date getShowDate(){
        return showDate;
    }
    public void setShowDate(Date showDate){
        this.showDate = showDate;
    }
    public Screen getScreen(){
        return screen;
    }
    public void setScreen(Screen screen){
        this.screen = screen;
    }
    public List<Integer> getBookedSeatIds(){
        return bookedSeatIds;
    }
    public void setBookedSeatsIds(List<Integer> bookedSeatIds){
        this.bookedSeatIds = bookedSeatIds; 
    }

}
