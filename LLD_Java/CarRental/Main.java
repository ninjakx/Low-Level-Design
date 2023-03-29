package Java.CarRental;
import java.util.List;
import java.util.ArrayList;
import Java.CarRental.Vehicle.*;
import Java.CarRental.VehicleCharges.*;
import Java.CarRental.Model.*;
import Java.CarRental.Reservation.*;
import Java.CarRental.Payement.*;

public class Main {

    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserID(1);
        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeID=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }


    public static void main(String args[]) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);
        User user = users.get(0);

        Location location = new Location("WhiteField", "Bangalore", "Karnataka", "India", 403012);
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        Vehicle bookedVehicle = storeVehicles.get(0);
        VehicleChargesFactory vehicleChargeFactory = new VehicleChargesFactory(VehicleChargesType.KM, bookedVehicle.getVehicleType());
        bookedVehicle.setVehicleCharges(vehicleChargeFactory.buildVehicleCharges());

        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(bookedVehicle, user);

        //4. generate the bill
        Invoice invoice = new Invoice(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(invoice);

        //6. trip completed, submit the vehicle and close the reservation
        store.reservationDone(reservation.reservationID);
        }
}
