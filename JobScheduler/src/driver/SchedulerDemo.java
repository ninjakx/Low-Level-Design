package JobScheduler.src.driver;

import java.util.concurrent.TimeUnit;

import JobScheduler.src.main.service.SchedulerService;

public class SchedulerDemo {
    public static void main(String[] args){
        SchedulerService schedulerService = SchedulerService.getInstance();

        Runnable task1 = () -> System.out.println("Running Task 1(onetime)");
        Runnable task2 = () -> System.out.println("Running Task 2(onetime)");

        schedulerService.schedule(task1, 10, TimeUnit.SECONDS);
        schedulerService.schedule(task2, 5, TimeUnit.SECONDS);

        Runnable task3 = () -> System.out.println("Running Task 3(at fixed Rate)");
        schedulerService.scheduledAtFixedRate(task3, 2, 2, TimeUnit.SECONDS);

        Runnable task4 = () -> {
            System.out.println("Runnin Task 4(with 1s processing delay).");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        schedulerService.scheduledFixedRateWithSomeDelay(task4, 1, 3, TimeUnit.SECONDS);
    }
}