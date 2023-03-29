package AirlineTicketBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AirlineTicketBooking.entity.Airport;
import AirlineTicketBooking.entity.Flight;

public class FlightController {
    Map<Airport, List<Flight>> airportVsflight;
    List<Flight> allflights;
    public FlightController() {
        this.airportVsflight = new HashMap<>();
        this.allflights = new ArrayList<>();
    }
    public List<Flight> getAirportFlights(Airport airport) {
        return airportVsflight.getOrDefault(airport, new ArrayList<>());
    }
    public List<Flight> getAllflights() {
        return allflights;
    }
    public void addAirportFlight(Airport airport, Flight flight) {
        this.airportVsflight.put(airport, allflights);
    }
    public void addflights(Flight flight) {
        this.allflights.add(flight);
    }
}
