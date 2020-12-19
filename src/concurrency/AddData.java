package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AddData {
    public static void main(String[] args) throws Exception {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result1 = service.submit(() -> {
                int a = 30 + 11;
            });//Runnable
            System.out.println(result1.get()); // null
            Future<Integer> result2 = service.submit(() -> 30 + 11);//Callable
            System.out.println(result2.get()); // 41

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
        if (service != null) {
            System.out.println(service.awaitTermination(1, TimeUnit.MINUTES));

            // Check whether all tasks are finished
            if (service.isTerminated())
                System.out.println("Finished!");
            else
                System.out.println("At least one task is still running");
        }
    }
}
