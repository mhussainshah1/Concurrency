package threadSafe.atomicClasses;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
    private AtomicInteger sheepCount = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet()+" ");
    }
}