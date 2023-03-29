package Java.Elevator.ElevatorCar;

public class ElevatorDisplay {
    int floor;
    Direction direction;

    public void setDisplay(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
    }

    public void showDisplay(){
        System.out.printf("floor: %d\n", floor);
        System.out.printf("Direction: %s\n\n", direction);
    }
}
