package concurrency;

import java.util.concurrent.*;

public class SchedulingTasks {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";

        ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES);

        //or
        Executor service2 = Executors.newSingleThreadScheduledExecutor();
        r1 = ((ScheduledExecutorService) service2).schedule(task1, 10, TimeUnit.SECONDS);
        r2 = ((ScheduledExecutorService) service2).schedule(task2, 8, TimeUnit.MINUTES);

        Runnable command = task1;
        service.scheduleAtFixedRate(command, 5, 1, TimeUnit.MINUTES);
        service.scheduleWithFixedDelay(command, 0, 2, TimeUnit.MINUTES);

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }
}
