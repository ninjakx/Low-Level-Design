package Elevator.InternalButton;
import Elevator.ElevatorCar.ElevatorCar;
import Elevator.ElevatorCar.ElevatorCreator;
import Elevator.ElevatorCar.ElevatorController;
import Elevator.ElevatorCar.ElevatorController.*;
import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;
    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
        //for simplicity, i am following even odd,
        for(ElevatorController elevatorController : elevatorControllerList) {
            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID==elevatorCar.id){
                elevatorController.submitInternalRequest(floor);
            } 
         }
    }

}
