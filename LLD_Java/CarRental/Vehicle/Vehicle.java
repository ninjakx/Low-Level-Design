package CarRental.Vehicle;

import CarRental.VehicleCharges.*;
import CarRental.Vehicle.*;

public class Vehicle {
    // vehicles details
    int vehicleID;
    int vehicleNumber;
    String companyName;
    String modelName;
    int kmDriven;
    int cc;
    int average;
    VehicleType vehicleType;
    int capacity; //no of seats 
    public VehicleCharges vehicleCharges;
    VehicleStatus vehicleStatus;

    public int getVehicleID(){
        return vehicleID;
    }
    public void setVehicleID(int vehicleID){
        this.vehicleID = vehicleID;
    }
    public int getVehicleNumber(){
        return vehicleNumber;
    }
    public void setVehicleNumber(int vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }
    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public String getmodelName(){
        return modelName;
    }
    public void setModelName(String modelName){
        this.modelName = modelName;
    }
    public int getKmDriven(){
        return kmDriven;
    }
    public void setKmDriven(int kmDriven){
        this.kmDriven = kmDriven;
    }
    public int getCc(){
        return cc;
    }
    public void setCc(int cc){
        this.cc = cc;
    }
    public int getAverage(){
        return average;
    }
    public void setAverage(int average){
        this.average = average;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public VehicleCharges getVehicleCharges(){
        return vehicleCharges;
    }
    public void setVehicleCharges(VehicleCharges vehicleCharges){
        this.vehicleCharges = vehicleCharges;
    }
    public VehicleStatus getVehicleStatus(){
        return vehicleStatus;
    }
    public void setVehicleStatus(VehicleStatus vehicleStatus){
        this.vehicleStatus = vehicleStatus;
    }
}
