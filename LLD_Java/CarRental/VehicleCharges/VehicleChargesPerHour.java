package CarRental.VehicleCharges;
import CarRental.Vehicle.*;
public class VehicleChargesPerHour extends VehicleCharges {
    VehicleType vehicleType;
    public VehicleChargesPerHour(VehicleType vehicleType){
        super(vehicleType);
    }
        
    @Override
    public int getVehicleRentAmount(){
        if (this.vehicleType==VehicleType.BIKE){
            // 20 RS per Hour
            int price = 20;
            return price;
        } else if (this.vehicleType==VehicleType.CAR){
            // 40 rs per KM
            int price = 40;
            return price;
        }
        return 15; // default
    }
}
