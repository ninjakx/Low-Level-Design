package AirlineTicketBooking.service;

import java.util.ArrayList;
import java.util.List;

import AirlineTicketBooking.entity.Airport;

public class AirportController {
    List<Airport> airportList;

    public AirportController() {
        this.airportList = new ArrayList<>();
    }

    public List<Airport> getAirportList() {
        return airportList;
    }

    public void addAirport(Airport airport) {
        this.airportList.add(airport);
    }
    public Airport getAirport(String location){
        List<Airport> airports = getAirportList();
        for (Airport airport: airports){
            if (airport.getLocation()==location){
                return airport;
            }
        }
        return null;
    }
}
