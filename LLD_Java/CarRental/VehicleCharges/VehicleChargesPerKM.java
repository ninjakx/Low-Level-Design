package Java.CarRental.VehicleCharges;
import Java.CarRental.Vehicle.*;
public class VehicleChargesPerKM extends VehicleCharges {
    public VehicleChargesPerKM(VehicleType vehicleType){
        super(vehicleType);
    }
        
    @Override
    public int getVehicleRentAmount(){
        if (this.vehicleType==VehicleType.BIKE){
            // 10 RS per KM
            int price = 10;
            return price;
        } else if (this.vehicleType==VehicleType.CAR){
            // 30 rs per KM
            int price = 30;
            return price;
        }
        return 35; // default
    }
}
