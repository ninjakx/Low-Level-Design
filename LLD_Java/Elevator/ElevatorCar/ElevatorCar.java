package Java.Elevator.ElevatorCar;

import Java.Elevator.InternalButton.InternalButtons;

public class ElevatorCar {
    int currentFloor;
    public int id; //elevator id
    InternalButtons internalButtons;
    ElevatorState elevatorState;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;
    ElevatorDisplay display; // current floor

    public ElevatorCar(){
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE; // default IDLE; MOVING can be set
        currentFloor=0; // default;
        elevatorDoor = new ElevatorDoor();
        elevatorDirection = Direction.UP; // default
    }

    public void showDisplay(){
        display.showDisplay();
    }

    public void PressButton(int destination){
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay(){
        System.out.printf("Elevator id: %s\n", id);
        this.display.setDisplay(currentFloor, elevatorDirection);
    }

    boolean moveElevator(Direction dir, int destinationFloor){ // by strategy (destinatio floor)
        int startFloor = currentFloor;
        if (dir==Direction.UP){
            for (int i=startFloor; i<=destinationFloor; i++){
                this.currentFloor = i;
                setDisplay();
                showDisplay();
                if (i==destinationFloor){
                    return true;
                }
            }
        }
        if (dir==Direction.DOWN){
            for (int i=startFloor; i>=destinationFloor; i--){
                this.currentFloor = i;
                setDisplay();
                showDisplay();
                if (i==destinationFloor){
                    return true;
                }
            }
        }
        return false;
    }

}
