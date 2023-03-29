package AirlineTicketBooking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import AirlineTicketBooking.entity.Flight;
import AirlineTicketBooking.entity.FlightSeat;
import AirlineTicketBooking.entity.Passenger;

public class ReservationSystem implements IReservationSystem {

    @Override
    public void bookTicket(Passenger passenger, int flightNum, int seatNum, Date date, int price) {
        // TODO 
        // Notification System and Payment to be implemented here
        System.out.printf("\nBooking Ticket For Passenger %s\nFlight number %d\nSeat number %d\nPrice %d\n", passenger.toString(), flightNum, 
        seatNum, price);
    }

    @Override
    public List<FlightSeat> getAvailableSeats(Flight flight) {
        // TODO Auto-generated method stub

        List<FlightSeat> flSeat = new ArrayList<>();
        if (flight==null){
            return flSeat;
        }
        for (FlightSeat flightSeat: flight.getSeats()){
            if (flightSeat.getAvailability()==true){
                flSeat.add(flightSeat);
            }
        }
        return flSeat;
    }  

}
