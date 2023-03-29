package AirlineTicketBooking.service;

import java.util.Date;
import java.util.List;

import AirlineTicketBooking.entity.Flight;
import AirlineTicketBooking.entity.FlightSeat;
import AirlineTicketBooking.entity.Passenger;

public interface IReservationSystem {
    public void bookTicket(Passenger passenger, int flightNum, int seatNum, Date date, int price); 
    public List<FlightSeat> getAvailableSeats(Flight flight) ;   
}
