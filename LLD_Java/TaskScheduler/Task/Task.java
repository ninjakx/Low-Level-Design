package Java.TaskScheduler.Task;
import java.util.UUID;

import Java.TaskScheduler.User.User;

public class Task {
    // tasktype, taskstatus
    // task id
    // assigned to user
    // created by user
    TaskType tasktype;
    TaskStatus taskStatus;
    String taskID;
    String Name;

    User user;
    public Task(){
        taskID = UUID.randomUUID().toString();
        this.taskStatus = TaskStatus.OPEN;
    }
    public String getTaskID() {
        return taskID;
    }

    public void setTasktype(TaskType tasktype) {
        this.tasktype = tasktype;
    }
    
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
}
