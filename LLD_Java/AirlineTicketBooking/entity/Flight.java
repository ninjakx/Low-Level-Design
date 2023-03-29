package AirlineTicketBooking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    
int flightNumber; // random UUID
   int numSeats;
   List<FlightSeat> seats;
   int duration;
   Airport arrival;
   Airport departure;
   Date from;
   Date to;

public Flight(int flightNumber, int numSeats, int duration, Airport arrival, Airport departure) {
    this.flightNumber = flightNumber;
    this.numSeats = numSeats;
    this.seats = new ArrayList<>();
    this.duration = duration;
    this.arrival = arrival;
    this.departure = departure;
    this.arrival.addFlight(this);
    this.departure.addFlight(this);
}

public int getFlightNumber() {
    return flightNumber;
}
public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
}
public int getNumSeats() {
    return numSeats;
}
public void setNumSeats(int numSeats) {
    this.numSeats = numSeats;
}
public List<FlightSeat> getSeats() {
    return seats;
}
public void setSeats(List<FlightSeat> flightSeats) {
    this.seats = flightSeats;
}
public void addSeat(FlightSeat seat) {
    this.seats.add(seat);
}
public int getDuration() {
    return duration;
}
public void setDuration(int duration) {
    this.duration = duration;
}
public Airport getArrival() {
    return arrival;
}
public void setArrival(Airport arrival) {
    this.arrival = arrival;
}
public Airport getDeparture() {
    return departure;
}
public void setDeparture(Airport departure) {
    this.departure = departure;
}
@Override
    public String toString() {
        return "Flight [flightNumber=" + flightNumber + ", duration=" + duration + "]";
    }

}
