package AirlineTicketBooking.entity;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    String name;
    String location;
    List<Flight> flights;
    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
        this.flights = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Flight> getFlights() {
        return flights;
    }
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
    @Override
    public String toString() {
        return "Airport [name=" + name + ", location=" + location + ", flights=" + flights + "]";
    }
}
