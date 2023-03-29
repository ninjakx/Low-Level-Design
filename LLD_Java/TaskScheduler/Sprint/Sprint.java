package Java.TaskScheduler.Sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Java.TaskScheduler.Task.Task;
import Java.TaskScheduler.Task.TaskStatus;
import Java.TaskScheduler.User.User;

public class Sprint {
    String sprintID;
    List<Task> taskList;
    List<User> userList;
    int begin;
    int end;
    String name;

    public Sprint(){
        sprintID = UUID.randomUUID().toString();
        userList = new ArrayList<>();
        taskList = new ArrayList<>();
    }
    public void createSprint(int begin, int end, String name){
        this.begin = begin;
        this.end = end;
        this.name = name;
    }
    public void addTask(Task task) {
        this.taskList.add(task);
    }
    public void addUser(User user){
        this.userList.add(user);
    }
    public void removeUser(User user){
        for (User usr: userList){
            if (usr.getUserId().equals(user.getUserId())){
                userList.remove(usr);
            }
        }
    }
    public List<Task> getTasks() {
        return taskList;
    }
    public List<User> getUserList() {
        return userList;
    }
    // update task status or type or user for a given sprint
    // remove task from sprint;
    public void removeTask(Task task){
        for (Task tsk: taskList){
            if (tsk.getTaskID().equals(task.getTaskID())){
                // IMP User iterator over Data type next
                // https://www.java67.com/2015/10/how-to-solve-concurrentmodificationexception-in-java-arraylist.html
                taskList.remove(tsk);
                // User usr = tsk.getUser();
                // usr.removeTask(tsk);
                break;
            }
        }
    }
    public void setTaskStatus(Task task, TaskStatus taskStatus){
        int flagFound = 0;
        for (Task tsk: taskList){
            if (tsk.getTaskID().equals(task.getTaskID())){
                tsk.setTaskStatus(taskStatus);
                flagFound = 1;
            }
        }
        if (flagFound==0){
            throw new RuntimeException("Given Task Not Found!!");
        }
    } 
    public String getSprintID() {
        return sprintID;
    }
    public void displayTasks(){
        System.out.println("Display Tasks===>");
        for (Task tsk: getTasks()){
            System.out.printf("Task ID: %s\nTask Name: %s\nTask Status: %s\n",tsk.getTaskID(), tsk.getName(), tsk.getTaskStatus());
        }
        System.out.println();
    }
    public void displayUser(){
        System.out.println("Display Users===>");
        for (User usr: getUserList()){
            System.out.printf("User ID: %s\n",usr.getUserId());
        }
        System.out.println();

    }
}
