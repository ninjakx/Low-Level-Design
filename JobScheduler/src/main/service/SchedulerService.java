package JobScheduler.src.main.service;

import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.print.attribute.standard.JobPriority;

import JobScheduler.src.main.entity.Job;
import JobScheduler.src.main.enums.TaskType;
import JobScheduler.src.main.helper.JobExecutor;

// @40:53
public class SchedulerService implements ISchedulerService{
    // Singleton - use all processors except 1 to prevent deprivation of interactive applications
    private static final SchedulerService INSTANCE = new SchedulerService(Runtime.getRuntime().availableProcessors()-1);
    private final PriorityQueue<Job> jobPriorityQueue;
    private final Lock queueLock;
    private final Condition entryAdded;

    private SchedulerService(int threadCount) {
        jobPriorityQueue = new PriorityQueue<>();
        queueLock = new ReentrantLock();
        entryAdded = queueLock.newCondition();

        // start a separate thread for JobExecutor
        Thread executor = new Thread(new JobExecutor(jobPriorityQueue, queueLock, entryAdded, threadCount));
        executor.start();
    }

    public static SchedulerService getInstance(){
        return INSTANCE;
    }

    public void addToJobQueue(Job job){
        queueLock.lock();
        try {
            jobPriorityQueue.offer(job);
            entryAdded.signal();
        } finally{
            queueLock.unlock();
        }
    }

    @Override
    public void schedule(Runnable task, long initialDelay, TimeUnit unit) {
        // TODO Auto-generated method stub
        Date date = new Date(Calendar.getInstance().getTime().getTime() + unit.toMillis(initialDelay));
        Job job = new Job(UUID.randomUUID().hashCode(), task, date);

        addToJobQueue(job);
    }

    @Override
    public void scheduledAtFixedRate(Runnable task, long initialDelay, long recurringDelay, TimeUnit unit) {
        // TODO Auto-generated method stub
        Date date = new Date(Calendar.getInstance().getTime().getTime() + unit.toMillis(initialDelay));
        Job job = new Job(UUID.randomUUID().hashCode(), task, date, recurringDelay, unit, TaskType.REPEAT_FIXED_RATE); 

        addToJobQueue(job);
    }

    @Override
    public void scheduledFixedRateWithSomeDelay(Runnable task, long initialDelay, long recurringDelay, TimeUnit unit) {
        // TODO Auto-generated method stub
        Date date = new Date(Calendar.getInstance().getTime().getTime() + unit.toMillis(initialDelay));
        Job job = new Job(UUID.randomUUID().hashCode(), task, date, recurringDelay, unit, TaskType.REPEAT_FIXED_DELAY); 
        
        addToJobQueue(job);
    }

}
