package review;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Seventeen {
    public static void main(String[] args) {


    }

    public void addAndPrintItems(BlockingQueue<Integer> queue) throws InterruptedException {
        queue.offer(103);
        queue.offer(20, 1, TimeUnit.SECONDS);
        queue.offer(85, 7, TimeUnit.HOURS);
        System.out.print(queue.poll(200, TimeUnit.NANOSECONDS));
        System.out.print(" " + queue.poll(1, TimeUnit.MINUTES));
    }
}
