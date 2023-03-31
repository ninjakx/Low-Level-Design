package CarRental.VehicleCharges;
import CarRental.Vehicle.*;
public class VehicleChargesFactory {
    VehicleChargesType vehicleChargesType;
    VehicleType vehicleType;
    public VehicleChargesFactory(VehicleChargesType vehicleChargesType, VehicleType vehicleType){
        this.vehicleChargesType = vehicleChargesType;
        this.vehicleType = vehicleType;
    }

    public VehicleCharges buildVehicleCharges(){
        VehicleCharges vehicleCharges = null;
        switch (vehicleChargesType){
            case HOUR:{
                vehicleCharges = new VehicleChargesPerHour(vehicleType);
                break;
            }
            case KM:{
                vehicleCharges = new VehicleChargesPerKM(vehicleType);
                break;
            }
            default:
                break;
        }
        return vehicleCharges;
    }
}
