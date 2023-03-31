package Elevator.ElevatorCar;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class ElevatorController {
    static PriorityQueue<Integer> MaxHeapDown;
    static PriorityQueue<Integer> MinHeapUp;  
    static Queue<Integer> Queue;  
    public ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        MaxHeapDown = new PriorityQueue<>();
        MinHeapUp = new PriorityQueue<>();///
        Queue = new ArrayDeque<Integer>();
    }

    public void submitExternalRequest(int floor, Direction direction){
        System.out.printf("\nAdded the request in queue for floor: %d and direction: %s\n", floor, direction);
        if (direction==Direction.DOWN && elevatorCar.currentFloor>=floor){
            MaxHeapDown.offer(floor);
        } else if(direction==Direction.UP && elevatorCar.currentFloor<=floor) {
            MinHeapUp.offer(floor);
        } else {
            Queue.offer(floor);
        }

        ControlElevator();
    }

    public void submitInternalRequest(int floor){
        System.out.printf("\nAdded the request for the elevator id: %d in queue for floor: %d\n", elevatorCar.id, floor);
        if (elevatorCar.elevatorDirection==Direction.DOWN && elevatorCar.currentFloor>=floor){
            MaxHeapDown.offer(floor);
        } else if(elevatorCar.elevatorDirection==Direction.UP && elevatorCar.currentFloor<=floor) {
            MinHeapUp.offer(floor);
        } else {
            Queue.offer(floor);
        }     
        ControlElevator();   
    }

    public void ControlElevator(){
        boolean flag = true;
        while(flag){
            if (elevatorCar.elevatorDirection == Direction.UP && !MinHeapUp.isEmpty()){
                int targetFloor = MinHeapUp.poll();
                flag = !elevatorCar.moveElevator(Direction.UP, targetFloor); // If not moved (reached)
            }
            if (elevatorCar.elevatorDirection == Direction.DOWN && !MaxHeapDown.isEmpty()){
                int targetFloor = MaxHeapDown.poll();
                flag = !elevatorCar.moveElevator(Direction.DOWN, targetFloor); // If not moved (reached)
            } else {
                if (Queue.isEmpty()) 
                {
                    if (elevatorCar.elevatorDirection==Direction.UP && MinHeapUp.isEmpty()){
                        elevatorCar.elevatorDirection = Direction.DOWN;
                    } else if (elevatorCar.elevatorDirection==Direction.DOWN && MaxHeapDown.isEmpty()){
                        elevatorCar.elevatorDirection = Direction.UP;
                    }
                }
                while(!Queue.isEmpty()){
                    int targetFloor = Queue.poll();
                    if (elevatorCar.currentFloor>=targetFloor){
                       elevatorCar.elevatorDirection = Direction.DOWN;
                       MaxHeapDown.offer(targetFloor);
                    }
                    else if (elevatorCar.currentFloor<=targetFloor){
                        elevatorCar.elevatorDirection = Direction.UP;
                        MinHeapUp.offer(targetFloor);
                     }
                }
            }
            // flag = false;
        }
    }
}
