package Java.RideSharing.Model;

import java.util.UUID;

public class Driver {
    private String id;
    private boolean isAvailable;
    private String name;

    private Trip currentTrip;
    
    public Driver(String name) {
        this.id = UUID.randomUUID().toString();
        this.isAvailable = true;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean status) {
        this.isAvailable=status;
    }
    public String getName() {
        return name;
    }
    public Trip getCurrentTrip() {
        return currentTrip;
    }
    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }
}
