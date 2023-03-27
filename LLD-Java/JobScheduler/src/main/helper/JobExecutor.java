package JobScheduler.src.main.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import JobScheduler.src.main.entity.Job;

// @44:26 timestamp, @35:18
public class JobExecutor implements Runnable{
    private final Executor jobExecutors;
    private PriorityQueue<Job> jobPriorityQueue;
    private Lock queueLock;
    private Condition entryAdded;
    public JobExecutor(PriorityQueue<Job> jobPriorityQueue, Lock queueLock,
            Condition entryAdded, int threadCount) {    
        this.jobPriorityQueue = jobPriorityQueue;
        this.queueLock = queueLock;
        this.entryAdded = entryAdded;
        jobExecutors = Executors.newFixedThreadPool(threadCount);
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            queueLock.lock();
            try {
                if (!jobPriorityQueue.isEmpty()){
                    Job job = jobPriorityQueue.peek();
                    Date startTime = job.getStartTime();
                    
                    Date current = Calendar.getInstance().getTime();

                    if (current.compareTo(startTime)>=0){
                        jobPriorityQueue.remove();
                        // alternative to native Thread approach
                        jobExecutors.execute(job);
                    } 

                        // Note: We will have to just keep trying, we cannot put a delay here as 
                        // we might skip a job if it's a scheduled during the sleep time
                        // Advanced: can we put it to Thread.sleep(current + startTime) and entryAdded await and resume if either is true.
                } else {
                    try {
                        entryAdded.await();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }  
            } finally {
                
            }
        }
        
    }

    
}
