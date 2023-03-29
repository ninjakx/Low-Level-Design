package Java.RideSharing;
import Java.RideSharing.Model.*;
import Java.RideSharing.Usecase.*;
import Java.RideSharing.Strategy.*;
import java.util.*;

public class RiderApp {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Driver 1");
        Driver driver2 = new Driver("Driver 2");
        Driver driver3 = new Driver("Driver 3");
        Driver driver4 = new Driver("Driver 4");

        DriverManager driverManager = new DriverManager();
        driverManager.createDriver(driver1);
        driverManager.createDriver(driver2);
        driverManager.createDriver(driver3);
        driverManager.createDriver(driver4);

        Rider rider1 = new Rider("Rider 1");
        Rider rider2 = new Rider("Rider 2");
        Rider rider3 = new Rider("Rider 3");

        RiderManager riderManager = new RiderManager();
        riderManager.createRider(rider1);
        riderManager.createRider(rider2);
        riderManager.createRider(rider3);

        TripManager tripManager = new TripManager(null, driverManager,  new PricingStrategyImpl(), new DriverMatchingStrategyImpl());
        tripManager.createTrip(rider3, 5, 2, 3);
        tripManager.createTrip(rider3, 10, 1, 3);
        tripManager.createTrip(rider2, 6, 1, 2);
        
        for (Rider rider: riderManager.getRiders()){
            String riderID = rider.getID();
            List<Trip> tripHistory = tripManager.tripHistory(rider);
            System.out.printf("For Rider: %s\n*********\n", rider.getName());
            for (Trip trpHst: tripHistory){
                System.out.printf("Trip ID: %s\n", trpHst.getId());
                System.out.printf("Trip Allocated Driver: %s\n", tripManager.getDriverForTrip(trpHst.getId(), riderID).get().getName());
            }
            System.out.println("*********");
        }
        for (Driver driver: driverManager.getDrivers()){
            Trip curTrip = driver.getCurrentTrip();
            System.out.printf("Get driver %s-> Current Trip: %s\n", driver.getName(), curTrip==null?"No current Trip":curTrip.getId());
        }
    }
}
