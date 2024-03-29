package Elevator.Building;
import Elevator.ExternalButton.*;
import Elevator.ElevatorCar.*;
public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispacher;

    public Floor(int floorNumber){
        this.floorNumber = floorNumber;
        externalDispacher = new ExternalDispatcher();
    }
    // In this floor, person can press a button to call lift
    public void pressButton(Direction direction){
        externalDispacher.submitExternalRequest(floorNumber, direction);
    }
}
