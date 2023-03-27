package JobScheduler.src.main.entity;

import java.util.concurrent.TimeUnit;

public class SchduledTask {
   private final Runnable runnable;
   private final int taskType;
   private final Long period;
   private final Long delay;
   private final TimeUnit unit;
   private Long scheduledTime;

   public Runnable getRunnable() {
    return runnable;
}

public SchduledTask(Runnable runnable, int taskType, Long period, Long delay, TimeUnit unit, Long scheduledTime) {
    this.runnable = runnable;
    this.taskType = taskType;
    this.period = period;
    this.delay = delay;
    this.unit = unit;
    this.scheduledTime = scheduledTime;
}

public int getTaskType() {
    return taskType;
}

public Long getPeriod() {
    return period;
}

public Long getDelay() {
    return delay;
}

public TimeUnit getUnit() {
    return unit;
}

public Long getScheduledTime() {
    return scheduledTime;
}
}
