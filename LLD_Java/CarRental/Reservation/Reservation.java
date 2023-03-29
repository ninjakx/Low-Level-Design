package Java.CarRental.Reservation;
import java.util.Date;

import Java.CarRental.VehicleCharges.*;
import Java.CarRental.Model.*;
import Java.CarRental.Vehicle.*;


public class Reservation {
    static int counter = 0;
    public int reservationID;
    User user;
    Vehicle vehicle;
    Date dateBookingFrom;
    Date dateBookingTo;
    long fromTimeStamp;
    long toTimestamp;
    Location pickUpLocation;
    Location dropLocation;
    public ReservationStatus reservationStatus;

    public int createReservation(User user, Vehicle vehicle){
        this.reservationID = counter;
        counter = counter+1;
        this.user = user;
        this.vehicle = vehicle;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        return reservationID;
    }

    public VehicleCharges getvehicleCharges(){
        return this.vehicle.getVehicleCharges();
    }

}
