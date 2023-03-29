package Java.Elevator.ExternalButton;

import Java.Elevator.ElevatorCar.ElevatorCreator;

import java.util.List;
import Java.Elevator.ElevatorCar.ElevatorController;
import Java.Elevator.ElevatorCar.Direction;

public class ExternalDispatcher {
    static List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;
    public void submitExternalRequest(int floor, Direction direction){

        //for simplicity, i am following even odd,
        for(ElevatorController elevatorController : elevatorControllerList) {
            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitExternalRequest(floor,direction);
 
            }
         }
 
    }
}
