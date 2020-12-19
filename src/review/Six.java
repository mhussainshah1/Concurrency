package review;

import java.util.List;

public class Six {
    public static void main(String[] args) throws Exception {
        var data = List.of(2,5,1,9,8);
        data.stream().parallel()
                .mapToInt(s -> s)
                .peek(System.out::print)
                .forEachOrdered(System.out::println);
    }
}
