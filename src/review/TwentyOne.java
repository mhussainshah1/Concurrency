package review;

import java.util.List;

public class TwentyOne {
    public static void main(String[] args) {
        var data = List.of(List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6));
        data.stream() // p1
                .flatMap(s -> s.stream())
                .findFirst() // p2
                .ifPresent(System.out::print);

        data.parallelStream() // p1
                .flatMap(s -> s.stream())
                .findFirst() // p2
                .ifPresent(System.out::print);
    }
}
