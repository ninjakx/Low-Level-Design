package AirlineTicketBooking;

import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

import AirlineTicketBooking.entity.Airport;
import AirlineTicketBooking.entity.Flight;
import AirlineTicketBooking.entity.FlightSeat;
import AirlineTicketBooking.entity.Passenger;
import AirlineTicketBooking.enums.SeatStatus;
import AirlineTicketBooking.enums.SeatType;
import AirlineTicketBooking.service.AirportController;
import AirlineTicketBooking.service.FlightController;
import AirlineTicketBooking.service.ReservationSystem;

public class AirlineTktBooking {
   AirportController airportController;
   FlightController flightController;
   public AirlineTktBooking() {
       airportController = new AirportController();
       flightController = new FlightController();
   }
   public void createAirport(){
      Airport airportLko = new Airport("Chaudhary Charan Singh Airport", "Lucknow");
      airportController.addAirport(airportLko);
      Airport airportKnp = new Airport("IGNU Airport", "Kanpur");
      airportController.addAirport(airportKnp);      
   }

   public void createFlight(){
      Airport dst = null ;
      Airport src = null;
      for (Airport airport : airportController.getAirportList()){
         if (airport.getLocation()=="Lucknow"){
            src = airport;
         } else if (airport.getLocation()=="Kanpur"){
            dst = airport;
         }
      }
      Flight indigoLkoKnp = new Flight(1, 50, 90, src, dst);
      List<FlightSeat> flightSeats = createSeat();
      indigoLkoKnp.setSeats(flightSeats);
      flightController.addAirportFlight(src, indigoLkoKnp);
      flightController.addflights(indigoLkoKnp);
   }

   public List<FlightSeat> createSeat(){
      List<FlightSeat> flightSeats = new ArrayList<>();
      for (int i=0; i<20; i++){
         FlightSeat flightSeat = new FlightSeat();
         flightSeat.setPrice(4000);
         flightSeat.setSeatType(SeatType.ECONOMY);
         flightSeats.add(flightSeat);
      }
      for (int i=20; i<30; i++){
         FlightSeat flightSeat = new FlightSeat();
         flightSeat.setPrice(5000);
         flightSeat.setSeatStatus(SeatStatus.RESERVED);
         flightSeat.setSeatType(SeatType.ECONOMY);
         flightSeats.add(flightSeat);
      }
      for (int i=30; i<50; i++){
         FlightSeat flightSeat = new FlightSeat();
         flightSeat.setPrice(6000);
         flightSeat.setSeatType(SeatType.ECONOMY);
         flightSeats.add(flightSeat);
      }
      return flightSeats;
   }

   public void initialize(){
      createAirport();
      createFlight();
   }

   private void createBooking(Airport from, Airport to, int seatNumber, Passenger passenger, int flightNum){
 
      //1. get all the flights originating from the source airport
      List<Flight> flights = flightController.getAirportFlights(from);

      //2. get all the flights going to destined location 
      List<Flight> allDstFlights = new ArrayList<>();
        for (Flight fl: flights){
            if (fl.getDeparture()==to)
            {
               allDstFlights.add(fl);
            }
      }  


      //3. select the Flight which you want to book.
      Flight targetFlight = null;
      for (Flight fl: allDstFlights){
            int num = fl.getFlightNumber();
          if (fl.getFlightNumber()==flightNum){
              targetFlight = fl;
          }
      }

      ReservationSystem reservationSys = new ReservationSystem();

      //5. select the seat and book it
      List<FlightSeat> avFlightSeats = reservationSys.getAvailableSeats(targetFlight);

      for (FlightSeat flseat: avFlightSeats){
         if(flseat.getSeatNumber()==seatNumber){
            reservationSys.bookTicket(passenger, flightNum, seatNumber, null, seatNumber);
            System.out.println("BOOKING SUCCESSFUL");
            return;
         } 
      }
      //throw exception
      System.out.println("seat already booked, try again");
      return;

  }

   public static void main(String args[]){

      AirlineTktBooking airlineTktBooking = new AirlineTktBooking();
      airlineTktBooking.initialize();

      Passenger passenger = new Passenger("luck", 9012, "something@gmail.com", "lily");

      Airport from = airlineTktBooking.airportController.getAirport("Lucknow");
      Airport to = airlineTktBooking.airportController.getAirport("Kanpur");
      airlineTktBooking.createBooking(from, to, 10, passenger, 1);

      //   Seat seat1 = new FlightSeat(10);
      //   Seat seat2 = new FlightSeat(20);
      //   AirportController airportController = new AirportController();
      //   FlightController flightController = new FlightController();

      //   Airport airportLko = new Airport("Chaudhary Charan Singh Airport", "Lucknow");
      //   airportController.addAirport(airportLko);
      //   Airport airportKnp = new Airport("IGNU Airport", "Kanpur");
      //   airportController.addAirport(airportKnp);

      //   Flight indigoLkoKnp = new Flight(1, 2, 90, airportLko, airportKnp);
      //   indigoLkoKnp.addSeat(seat1);
      //   indigoLkoKnp.addSeat(seat2);
      //   flightController.addAirportFlight(airportKnp, indigoLkoKnp);
      //   flightController.addAirportFlight(airportLko, indigoLkoKnp);

      //   ReservationSystem reservationSys = new ReservationSystem();
      //   reservationSys.bookTicket(1, 1, null, 100); 
   } 
}
