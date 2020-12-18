package parallelStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class State {
    public static void main(String[] args) {
        var list = addValues(IntStream.range(1, 11));
        System.out.println(list);

        list = addValues(IntStream.range(1, 11).parallel());
        System.out.println(list);

        list = addValues2(IntStream.range(1, 11).parallel());
        System.out.println(list);
    }

    //stateful
    public static List<Integer> addValues(IntStream source) {
        var data = Collections.synchronizedList(new ArrayList<Integer>());
        source.filter(s -> s % 2 == 0)
                .forEach(i -> {data.add(i);}); // STATEFUL: DON'T DO THIS!
        return data;
    }

    //stateless
    public static List<Integer> addValues2(IntStream source) {
        return source.filter(s -> s % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
