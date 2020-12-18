package parallelStream;

import java.util.List;
import java.util.stream.Stream;

public class Reduction {
    public static void main(String[] args) {
        //Order-Based Task
        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .findAny().get());//1

        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .findAny().get());//4

        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .skip(5)
                .limit(2)
                .findFirst().get());//6

        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .skip(5)
                .limit(2)
                .findFirst().get());//6

        //unordered stream
        var unordered = List.of(1, 2, 3, 4, 5, 6).stream().unordered();
        unordered.skip(5).forEach(System.out::print);//6

        Stream<Integer> parallel = List.of(1, 2, 3, 4, 5, 6).stream().unordered().parallel();
        parallel.skip(5).forEach(System.out::println);//6

        //Combining Results
        System.out.println(List.of('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce("",
                        (s1, c) -> s1 + c,
                        (s2, s3) -> s2 + s3)); // wolf

        //PROBLEMATIC ACCUMULATOR
        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> (a - b))); //-21 or 3

        System.out.println(List.of("w", "o", "l", "f")
                .parallelStream()
                .reduce("X", String::concat)); // XwXoXlXf

        System.out.println(List.of("w", "o", "l", "f")
                .stream()
                .reduce("X", String::concat)); // Xwolf
    }
}
