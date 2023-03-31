package Elevator.ElevatorCar;
import java.util.List;
import java.util.ArrayList;

public class ElevatorCreator {
    public static List<ElevatorController> elevatorControllerList = new ArrayList<>();

    public void addElevatorCar(int elevatorID){
        ElevatorCar elevatorCar = new ElevatorCar();
        elevatorCar.id = elevatorID;
        ElevatorController controller = new ElevatorController(elevatorCar); 
        elevatorControllerList.add(controller);      
    }

    public void DisplayAllElevatorCar(){
        for(ElevatorController elv: elevatorControllerList){
            System.out.println("ID: " + elv.elevatorCar.id);
        }
    }
}


    // static {
    //     ElevatorCar elevatorCar1 = new ElevatorCar();
    //     elevatorCar1.id = 1;
    //     ElevatorController controller1 = new ElevatorController(elevatorCar1);

    //     ElevatorCar elevatorCar2 = new ElevatorCar();
    //     elevatorCar2.id = 2;
    //     ElevatorController controller2 = new ElevatorController(elevatorCar2);

    //     elevatorControllerList.add(controller1);
    //     elevatorControllerList.add(controller2);
    // }

