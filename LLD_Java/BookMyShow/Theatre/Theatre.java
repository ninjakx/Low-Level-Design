package BookMyShow.Theatre;
import java.util.ArrayList;
import java.util.List;
import BookMyShow.Model.*;
public class Theatre {
    int theatreID;
    Location location;
    List<Screen> screens = new ArrayList<>(); // All the Available screens
    List<Show> shows = new ArrayList<>(); // All the shows

    public int getTheatreID(){
        return theatreID;
    }
    public void setTheatreID(int theatreID){
        this.theatreID=theatreID;
    }
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location=location;
    }
    public List<Show> getShows(){
        return shows;
    }
    public void setShows(List<Show> shows){
        this.shows=shows;
    }
    public List<Screen> getScreens(){
        return screens;
    }
    public void setScreens(List<Screen> screens){
        this.screens=screens;
    }
}
