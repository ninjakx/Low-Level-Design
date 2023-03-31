package CarRental;
import java.util.ArrayList;
import java.util.List;
import CarRental.Vehicle.*;;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;
    public VehicleInventoryManagement(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        List<Vehicle> vehiclesWithType = new ArrayList<>();
        for (Vehicle vehl: vehicles){
            if (vehl.getVehicleType()==vehicleType){
                vehiclesWithType.add(vehl);
            }
        }
        return vehiclesWithType;
    }

    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
}
