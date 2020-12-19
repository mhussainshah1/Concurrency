package review;

import java.util.concurrent.*;

public class Four {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        ExecutorService service =                   // w1 - ScheduledExecutorService
                Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(() -> {
            System.out.println("Open Zoo");
            return null;                            // w2 - remove null
        }, 0, 1, TimeUnit.MINUTES);
        var result = service.submit(() ->           // w3
                System.out.println("Wake Staff"));
        System.out.println(result.get());           // w4
        */
    }
}