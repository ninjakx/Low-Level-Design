package Java.Elevator.InternalButton;
import Java.Elevator.ElevatorCar.ElevatorCar;
import Java.Elevator.ElevatorCar.ElevatorCreator;
import Java.Elevator.ElevatorCar.ElevatorController;
import Java.Elevator.ElevatorCar.ElevatorController.*;
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
