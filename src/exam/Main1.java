package exam;
/**
 * You must make the count variable thread safe.
 * Which two modifications meet your requirement?
 * A) replace line 2 with public static synchronized void main(String[] args) {
 * B) replace line 3 with
 * synchronized(test) {
 * test.count++;
 * }
 * C) replace line 1 with private AtomicInteger count = new AtomicInteger(0) ; and replace line 3
 * with test.count.incrementAndGet();
 * D) replace line 1 with private volatile int count = 0;
 * E) replace line 3 with
 * synchronized(test.count) {
 * test.count++;
 * }
 * <p>
 * Answer B, C
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main1 {

    private volatile int count = 0; // line 1
//    private AtomicInteger count = new AtomicInteger(0) ;

    public static void main(String[] args) { // line 2
        Main1 test = new Main1();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    test.count++;
                   /* synchronized (test) {
                        System.out.print(test.count++ + ", "); // line 3
                    }*/
//                    System.out.println(test.count.incrementAndGet());
                }
            });
        }
        service.shutdown();
    }
}