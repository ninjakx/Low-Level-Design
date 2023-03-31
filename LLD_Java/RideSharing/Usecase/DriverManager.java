package RideSharing.Usecase;
import RideSharing.Model.*;
import java.util.*;
public class DriverManager {
    private List<Driver> drivers;
    public DriverManager() {
        this.drivers = new ArrayList<>();
    }
    public List<Driver> getDrivers() {
        return drivers;
    }
    public void createDriver(Driver driver){
        this.drivers.add(driver);      
    }
    public void updateDriverAvailability(String ID, boolean status){
        for (Driver driver: drivers){
            if (driver.getId() == ID){
                driver.setAvailable(status);
            }
        }
    }

}
