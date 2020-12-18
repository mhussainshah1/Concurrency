package exam;
/**
 * Which statement is true?
 *
 * A) It never finishes.
 *
 * B) The action of CyclicBarrier is called five times.
 *
 * C) It finishes without any exception.
 *
 * D) Threads in executorService execute for each of the two threads.
 *
 * [0, 1, 2, 3, 4][0, 1, 2, 3, 4]
 * Answer D
 */

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.print(list));
        IntStream.range(0, 5).forEach(n -> executorService.execute(() -> {
            try {
                list.add(n);
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println("Exception");
            }
        }));
        executorService.shutdown();
    }
}