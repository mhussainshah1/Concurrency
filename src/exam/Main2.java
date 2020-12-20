package exam;
/**
 * Which statement is true?
 * <p>
 * A) It never finishes.
 * <p>
 * B) The action of CyclicBarrier is called five times.
 * <p>
 * C) It finishes without any exception.
 * <p>
 * D) Threads in executorService execute for each of the two threads.
 * <p>
 *
 * Answer A
 */

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.print(list));
        IntStream.range(0, 5)
                .forEach(n -> executorService.execute(() -> {
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