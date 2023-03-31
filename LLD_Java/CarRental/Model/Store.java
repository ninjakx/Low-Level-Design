package CarRental.Model;

import java.util.ArrayList;
import java.util.List;
import CarRental.Reservation.*;
import CarRental.*;
import CarRental.Vehicle.*;

public class Store {
    List<Reservation> reservationList = new ArrayList<>();
    public int storeID;
    int status;
    // Inventory management
    VehicleInventoryManagement inventoryManagement;
    Location location;

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return inventoryManagement.getVehicles(vehicleType);
    }

    public void setVehicles(List<Vehicle> vehicles){
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }
    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReservation(user, vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public boolean reservationDone(int reservationID){
        // marked that reservation as completed
        reservationList.get(reservationID).reservationStatus = ReservationStatus.COMPLETED;
        return true;
    }

}
