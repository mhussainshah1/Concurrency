package parallelStream;

import java.util.List;

public class Decomposition {
    public static void main(String[] args) {

        //serial stream
        long start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5)
                .stream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");

        //Parallel Stream
        start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");

        //ordered For Each
        start = System.currentTimeMillis();
        List.of(5,2,1,4,3)
                .parallelStream()
                .map(w -> doWork(w))
                .forEachOrdered(s -> System.out.print(s + " "));
        System.out.println();
        timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Time: " + timeTaken + " seconds");
    }

    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input;
    }
}
