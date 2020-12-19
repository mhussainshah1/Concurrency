package review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TwentyTwo {
    private AtomicInteger s1 = new AtomicInteger(0); // w1
    private int s2 = 0;

    public static void main(String[] args) throws InterruptedException {
        new TwentyTwo().countSheep();
    }

    private void countSheep() throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2 - if we use newScheduledThreadPool(2) the output would be indeterminate
            for (int i = 0; i < 100; i++)
                service.execute(() -> {
                    s1.getAndIncrement();
                    s2++;
                }); // w3
            Thread.sleep(100);
            System.out.println(s1 + " " + s2);
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
