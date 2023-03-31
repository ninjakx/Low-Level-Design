package TaskScheduler.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import TaskScheduler.Sprint.Sprint;
import TaskScheduler.Task.Task;
import TaskScheduler.Task.TaskStatus;
import TaskScheduler.Task.TaskType;

public class User {
    List<Task> taskList;
    static List<Sprint> sprintList;

    String userID;
    // create task
    // create sprint
    // add task to sprint
    // remove task to sprint
    // change the status of task
    // update task -> move to sprint, change status
    public User(){
        userID = UUID.randomUUID().toString();
        taskList = new ArrayList<>();
        sprintList = new ArrayList<>();
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }

    public void removeTask(Task task){
        for (Task tsk: taskList){
            if (tsk.getTaskID().equals(task.getTaskID())){
                taskList.remove(tsk);
                break;
            }
        }
    }

    public void addSprint(Sprint sprint){
        this.sprintList.add(sprint);
    }

    public void removeSprint(Sprint sprint){
        for (Sprint spr: sprintList){
            if (spr.getSprintID().equals(sprint.getSprintID())){
                sprintList.remove(spr);
            }
        }
    }

    public String getUserId(){
        return userID;
    }

    public Task createTask(TaskType taskType, String taskName){
        Task task = new Task();
        task.setTasktype(taskType);
        addTask(task);
        task.setName(taskName);
        task.setUser(this);
        return task;
    }
    public Sprint createSprint(int begin, int end, String name){
        Sprint sprint = new Sprint();
        sprint.createSprint(begin, end, name);
        sprint.addUser(this);
        sprintList.add(sprint);
        return sprint;
    }

    public void addToSprint(Sprint sprint, Task task){
        for (Sprint spr: sprintList){
            if (spr.getSprintID().equals(sprint.getSprintID())){
                System.out.println("yes");
                spr.addTask(task);
                spr.addUser(this);
            }
        }
    }

    public void removeFromSprint(Sprint sprint, Task task){
        for (Sprint spr: sprintList){
            if (spr.getSprintID().equals(sprint.getSprintID())){
               List<Task> tsks = spr.getTasks();
                for (Task tsk: tsks){
                    if (tsk.getTaskID().equals(task.getTaskID())){
                        spr.removeTask(task);
                        tsk.setUser(null);
                    }
                }
            }
        }
    }
    public List<Task> getTaskList() {
        return taskList;
    }

    public List<Sprint> getSprintList() {
        return sprintList;
    }
    public void setTaskStatus(Task task, TaskStatus taskStatus){
        for (Task tsk: taskList){
            if (tsk.getTaskID().equals(task.getTaskID())){
                tsk.setTaskStatus(taskStatus);
            }
        }
    }
    public void displayTasks(){
        System.out.println("Display Tasks For Users===>");
        for (Task tsk: getTaskList()){
            System.out.printf("Task ID: %s\n",tsk.getTaskID());
        }
        System.out.println();
    }    
}
