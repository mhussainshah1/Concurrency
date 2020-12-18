package threadSafe.synchronizedBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {

    private final Object herd = new Object();
    private int sheepCount = 0;

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
//          synchronized(manager) {//synchronized creation not execution
            // Work to be completed by one thread at a time
            for (int i = 0; i < 10; i++)
//          synchronized(manager) {//synchronized creation not execution
                service.submit(() -> manager.incrementAndReport());
//          }
        } finally {
            if (service != null)
                service.shutdown();
        }
    }

    //instance method
    //synchronized block
    private void incrementAndReport() {
//        synchronized (this) {
        //or
        synchronized (herd) {
            System.out.print((++sheepCount) + " ");
        }
    }

    //or
    // synchronized method
    private synchronized void incrementAndReport2() {
        System.out.print((++sheepCount)+" ");
    }

    //static method
    public static void printDaysWork() {
        synchronized(SheepManager.class) {
            System.out.print("Finished work");
        }
    }
    //or
    public static synchronized void printDaysWork2() {
        System.out.print("Finished work");
    }
}