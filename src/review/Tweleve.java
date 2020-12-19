package review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tweleve {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            service.execute(() -> takeNap());
            service.execute(() -> takeNap());
            service.execute(() -> takeNap());
        } finally {
            if (service != null) service.shutdown();
        }
        System.out.println(service.awaitTermination(2, TimeUnit.SECONDS));
        System.out.println("DONE!");
    }

    public static void takeNap(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
