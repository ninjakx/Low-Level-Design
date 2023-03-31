package RideSharing.Model;

import java.util.UUID;

public class Trip {
    private TripStatus tripStatus;
    private String id;
    private Rider rider;
    private Driver driver;
    private int destination;
    private int origin;
    private double fare;
    private int seats;

    public Trip(
                final Rider rider,
                final Driver driver,
                final int destination,
                final int origin,
                final double fare,
                final int seats)
    {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.driver = driver;
        this.destination = destination;
        this.origin = origin;
        this.fare = fare;
        this.seats = seats;
        this.tripStatus = TripStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public Rider getRider() {
        return this.rider;
    }

    public Driver getDriver() {
        return this.driver;
    }


    public int getDestination() {
        return destination;
    }

    public int getOrigin() {
        return origin;
    }

    public double getFare() {
        return fare;
    }

    public int getSeats() {
        return seats;
    }


    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void withDrawTrip(){
        this.tripStatus = TripStatus.WITHDRAWN;
    }
    public void endTrip(){
        this.tripStatus = TripStatus.FINISHED;
    }

    public void updateTrip(int dst, int org, int nseats, double price){
        this.destination = dst;
        this.origin = org;
        this.seats = nseats;
        this.fare = fare;
    }

}
