package TaskScheduler;

import TaskScheduler.Sprint.Sprint;
import TaskScheduler.Task.Task;
import TaskScheduler.Task.TaskStatus;
import TaskScheduler.Task.TaskType;
import TaskScheduler.User.User;

public class Scheduler {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        Task task1 = user1.createTask(TaskType.FEATURE, "task1"); 
        Task task2 = user1.createTask(TaskType.STORY, "task2"); 
        Task task3 = user2.createTask(TaskType.STORY, "task3"); 

        Sprint sprint1 = user1.createSprint(1, 10, "Sprint 1");
        sprint1.addTask(task1);
        sprint1.addTask(task2);

        user2.addToSprint(sprint1, task3);
        sprint1.displayTasks();
        sprint1.displayUser();

        sprint1.removeTask(task3);
        sprint1.displayTasks();
        sprint1.displayUser();

        sprint1.setTaskStatus(task2, TaskStatus.IN_PROGRESS);
        sprint1.displayTasks();

        Sprint sprint2 = user2.createSprint(1,4,"Sprint 2");
        sprint1.removeTask(task2);
        sprint2.addTask(task2);
        sprint1.displayTasks();
        sprint2.displayTasks();
    }

}
