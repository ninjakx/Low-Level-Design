package CarRental.VehicleCharges;

import CarRental.Vehicle.VehicleType;
// https://www.w3schools.com/java/java_abstract.asp
// Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
public abstract class VehicleCharges {
    VehicleType vehicleType;
    public VehicleCharges(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }
    public abstract int getVehicleRentAmount();
}
