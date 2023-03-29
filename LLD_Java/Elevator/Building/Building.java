package Java.Elevator.Building;

import java.util.List;
public class Building {
    List<Floor> floorList;
    public Building(List<Floor> floors){
        this.floorList = floors;
    }

    public void addFloors(Floor newFloor){
        floorList.add(newFloor);
    }
    public void removeFloors(Floor newFloor){
        floorList.remove(newFloor);
    }
    List<Floor> getAllFloorList(){
        return floorList;
    }
}
