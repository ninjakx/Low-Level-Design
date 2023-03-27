package JobScheduler.src.main.service;

import java.util.concurrent.TimeUnit;

public interface ISchedulerService {
    public void schedule(Runnable task, long initialDelay, TimeUnit unit);
    public void scheduledAtFixedRate(Runnable task, long initialDelay, long recurringDelay, TimeUnit unit);
    public void scheduledFixedRateWithSomeDelay(Runnable task, long initialDelay, long recurringDelay, TimeUnit unit); // there will be an additionalprocessing delay
}
