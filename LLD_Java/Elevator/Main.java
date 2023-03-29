package Java.Elevator;

import java.util.ArrayList;
import java.util.List;
import Java.Elevator.Building.*;
import Java.Elevator.ElevatorCar.*;
// import Java.Elevator.ElevatorCar.ElevatorCreator;

public class Main {

    public static void main(String args[]) {
        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        Floor floor6 = new Floor(6);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);
        floorList.add(floor6);

        Building building = new Building(floorList);
        ElevatorCreator elv = new ElevatorCreator();
        for(int i=1; i<10; i++){
            elv.addElevatorCar(i);
        }
        elv.DisplayAllElevatorCar();

        floor4.pressButton(Direction.UP);
        floor2.pressButton(Direction.DOWN);
        floor6.pressButton(Direction.UP);
        floor4.pressButton(Direction.UP);
        floor2.pressButton(Direction.UP);

        List<ElevatorController> elevatoCarControllerList = ElevatorCreator.elevatorControllerList;
        elevatoCarControllerList.get(1).submitInternalRequest(6);

        // ElevatorCreator elv = null;
        // List<ElevatorController> elevatorControllerList = elv.elevatorControllerList;
        // for(ElevatorController elevatorController : elevatorControllerList) {
        //     System.out.println(elevatorController.elevatorCar.id);
        // }
        
    }
}
