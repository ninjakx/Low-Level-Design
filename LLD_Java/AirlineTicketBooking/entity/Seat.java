package AirlineTicketBooking.entity;

import AirlineTicketBooking.enums.SeatStatus;
import AirlineTicketBooking.enums.SeatType;

public class Seat {
   int seatNumber;
   SeatType seatType;
//    double price; // -- price service 
//    boolean availability; 
//    SeatStatus seatStatus;
// public Seat(int seatNumber, SeatType seatType, Seat availability) {
//     this.seatNumber = seatNumber;
//     this.seatType = seatType;
//     this.availability = availability;
// }
public int getSeatNumber() {
    return seatNumber;
}
public void setSeatNumber(int seatNumber) {
    this.seatNumber = seatNumber;
}
public SeatType getSeatType() {
    return seatType;
}
public void setSeatType(SeatType seatType) {
    this.seatType = seatType;
}

// public void setAvailability(Boolean availability) {
//     this.availability = availability;
// }
@Override
public String toString() {
    return "Seat [seatNumber=" + seatNumber + ", seatType=" + seatType + "]";
}

}