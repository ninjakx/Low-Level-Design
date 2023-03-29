package Java.RideSharing.Usecase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Java.RideSharing.Model.*;
import Java.RideSharing.Strategy.DriverMatchingStrategy;
import Java.RideSharing.Strategy.PricingStrategy;
public class TripManager {
    private Map<String, List<Trip>> trips; // rider ID and its trips
    private RiderManager riderManager;
    private DriverManager driverManager;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;
    // private
    public TripManager(final RiderManager riderManager, final DriverManager driverManager, final PricingStrategy pricingStrategy,
    final DriverMatchingStrategy driverMatchingStrategy){
        this.trips = new HashMap<>();
        this.riderManager = riderManager;
        this.driverManager =driverManager;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
    }

    private double computeFare(final Rider rider, int destination, int origin, int seats){
        // Rider is used to check if the rating is high for this and is regular customer then give them discount
        return pricingStrategy.calculateFare(origin, destination, seats);
    }
    public String createTrip(final Rider rider, final int destination, final int origin, final int seats){
        if (origin >= destination){
            throw new RuntimeException("origin should not be greater than the destination");
        }

        // Find driver for this ride if not found throw exceptions
        List<Driver> drivers = driverManager.getDrivers();
        // Optional: A container object which may or may not contain a non-null value
        Optional<Driver> matchedDriver = driverMatchingStrategy.findDriver(rider, drivers, destination, origin);
        if (!matchedDriver.isPresent()){
            throw new RuntimeException("Driver not found");
        }
        Driver driver = matchedDriver.get();

        double fare = computeFare(rider, destination, origin, seats);

        Trip trip = new Trip(rider, driver, destination, origin, fare, seats);

        if (!trips.containsKey(trip.getRider().getID())){
            trips.put(rider.getID(), new ArrayList<>());
        }
        trips.get(rider.getID()).add(trip);
        driver.setCurrentTrip(trip);
        return trip.getId();
    }

    public void updateTrip(final String tripID, int riderID, final int origin, final int destination, final int seats){
        if (origin >= destination){
            throw new RuntimeException("origin should be greater than the destination");
        }

        Optional<Trip> trip = this.getTrip(tripID, riderID);
        if (!trip.isPresent()){
            throw new RuntimeException("trip not found");
        }

        Trip curTrip = trip.get();

        if (curTrip.getTripStatus().equals(TripStatus.FINISHED) || curTrip.getTripStatus().equals(TripStatus.WITHDRAWN)){
            throw new RuntimeException("Trip has been done / withdrawn");
        }
        double fare = computeFare(curTrip.getRider(), destination, origin, seats);
        curTrip.updateTrip(destination, origin, seats, fare);
    }

    public List<Trip> getTripHistory(final Rider rider){
        return trips.getOrDefault(rider.getID(), new ArrayList<>());
    }

    public Optional<Driver> getDriverForTrip(final String tripID, final String riderID){
        for (Map.Entry<String, List<Trip>>  tripList : trips.entrySet()) {
            if(tripList.getKey().equals(riderID)){
                for (Trip trp: tripList.getValue()){
                    if (trp.getId().equals(tripID)){
                        return Optional.ofNullable(trp.getDriver());
                    }
                }
            }
        }
        return Optional.empty();
    }
    
    public void withDrawTrip(final String tripID, final int riderID){
        Trip trip = null;
        for (Map.Entry<String, List<Trip>>  tripList : trips.entrySet()) {
            if(tripList.getKey().equals(riderID)){
                for (Trip trp: tripList.getValue()){
                    if (trp.getId().equals(tripID)){
                        trip = trp;
                    }
                }
            }
        }
        if (trip == null || trip.getTripStatus().equals(TripStatus.FINISHED)){
            throw new RuntimeException("Trip not Exist or already completed");
        } else {
            Driver driver = trip.getDriver();
            driver.setCurrentTrip(null);
            trip.withDrawTrip();
        }
        
    }

    public Optional<Trip> getTrip(final String tripID, final int riderID){
        // return trips.values().stream()
        // .flatMap(list -> list.stream())
        // .filter(t -> t.getId().equals(tripId))
        // .findFirst();

        for (Map.Entry<String, List<Trip>>  tripList : trips.entrySet()) {
            if(tripList.getKey().equals(riderID)){
                for (Trip trp: tripList.getValue()){
                    if (trp.getId().equals(tripID)){
                        return Optional.ofNullable(trp);
                    }
                }
            }
        }
    return Optional.empty();
    }

    public double endTrip(Driver driver){ // get fare 
        if (driver.getCurrentTrip()==null){
            throw new RuntimeException("Currently rider is not riding. please try again");
        }

        double fare = driver.getCurrentTrip().getFare();
        driver.getCurrentTrip().endTrip();
        driver.setCurrentTrip(null);
        return fare;
    }
    public List<Trip> tripHistory(final Rider rider){
        return trips.getOrDefault(rider.getID(), new ArrayList<>());
    }
}
