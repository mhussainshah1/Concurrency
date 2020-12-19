package review;

import java.util.concurrent.ExecutionException;

public class PrintCounter {
    static int count = 0;

    public static void main(String[] args) throws  InterruptedException, ExecutionException {
      /*  ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            var r = new ArrayList<Future<?>>();
            IntStream.iterate(0, i -> i + 1).limit(5).forEach(
                    i -> r.add(service.execute(() -> {count++;})) // n1 - not lambda function of Runnable
            for (Future<?> result : r) {
                System.out.print(result.get() + " "); // n2
            }
        } finally {
            if (service != null) service.shutdown();
        }*/
    }
}
