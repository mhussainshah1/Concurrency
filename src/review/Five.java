package review;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Five {
    public static void main(String[] args) {
        var value1 = new AtomicLong(0);
        final long[] value2 = {0};
        IntStream.iterate(1, i -> 1).limit(100).parallel()
                .forEach(i -> value1.incrementAndGet());
        IntStream.iterate(1, i -> 1).limit(100).parallel()
                .forEach(i -> ++value2[0]);
        System.out.println(value1+" "+value2[0]);
    }
}
