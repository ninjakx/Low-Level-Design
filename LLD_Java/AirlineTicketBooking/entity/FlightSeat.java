package AirlineTicketBooking.entity;

import AirlineTicketBooking.enums.SeatStatus;

public class FlightSeat extends Seat {
   double price; // -- price service 
   SeatStatus seatStatus;
   static  int seatCounter = 0;

   public FlightSeat() {
    this.price = 3000;
    this.seatStatus = SeatStatus.AVAILABLE;
    this.seatNumber = seatCounter;
    seatCounter++;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}
public SeatStatus getSeatStatus() {
    return seatStatus;
}
public void setSeatStatus(SeatStatus seatStatus) {
    this.seatStatus = seatStatus;
}
public boolean getAvailability() {
    return (this.getSeatStatus().equals(SeatStatus.AVAILABLE));
}
@Override
public String toString() {
    return "FlightSeat [price=" + price + ", seatStatus=" + seatStatus + "]";
}    
}
