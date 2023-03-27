package JobScheduler.src.main.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import JobScheduler.src.main.enums.TaskType;
import JobScheduler.src.main.service.SchedulerService;
/**
* https://www.geeksforgeeks.org/difference-between-job-task-and-process/
*/
// @53:28
public class Job implements Runnable, Comparable<Job> {
    private final int jobId;
    private final Runnable task;
    private final Date startTime;
    private final long rescheduledPeriod;
    private final TimeUnit unit;
    private final TaskType taskType;


    public Job(int jobID, Runnable task, Date startTime){
        // this(jobId, task, startTime, -1, TimeUnit.SECONDS, TaskType.ONCE); // additional dummy params
        this.jobId = jobID;
        this.task = task;
        this.startTime = startTime;
        this.rescheduledPeriod = -1;
        this.unit = TimeUnit.SECONDS;
        this.taskType = TaskType.ONCE;
    }
    public Job(int jobId, Runnable task, Date startTime, long rescheduledPeriod, TimeUnit unit, TaskType taskType) {
        this.jobId = jobId;
        this.task = task;
        this.startTime = startTime;
        this.rescheduledPeriod = rescheduledPeriod;
        this.unit = unit;
        this.taskType = taskType;
    }

    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void run(){

        //AtFixedRate - trigger before - no need to wait for the task completion
        if (taskType.REPEAT_FIXED_RATE.equals(taskType)) {
            // Recursively schedule the next task even before completing the current one
            SchedulerService.getInstance().scheduledAtFixedRate(this.task, rescheduledPeriod, rescheduledPeriod ,unit);
        }
        System.out.printf("Running main.entity.Job : %s at time %d%n", jobId, Calendar.getInstance().get(Calendar.SECOND));
        
        try {
            task.run(); //sync - wait.
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //WithFiXedDelay - trigger after - wait for the task to finish
            if (taskType.REPEAT_FIXED_DELAY.equals(taskType)){
                // Recursively schedule the next task after completing the current
                SchedulerService.getInstance().scheduledFixedRateWithSomeDelay(this.task, rescheduledPeriod, rescheduledPeriod, unit);
            }
        }
    }
    // @55:02
    @Override
    public int compareTo(Job otherJob) {
        return this.startTime.compareTo(otherJob.startTime);
    }
}



