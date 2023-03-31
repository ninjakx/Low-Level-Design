package RideSharing.Usecase;

import java.util.ArrayList;
import java.util.List;
import RideSharing.Model.*;

public class RiderManager {
    private List<Rider> riders;
    public RiderManager() {
        this.riders = new ArrayList<>();
    }
    public List<Rider> getRiders() {
        return riders;
    }
    public void createRider(Rider rider){
        this.riders.add(rider);      
    }
}
