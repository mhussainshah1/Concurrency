package parallelStream;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
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
        //reduce()
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

        //collect()
        //#1: ConcurrentSkipListSet
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
                Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]

        //#2: toSet()
        Set<String> collect = Stream
                .of("w", "o", "l", "f")
                .parallel()
                .collect(Collectors.toSet());// Not a parallel reduction - Collectors.toSet() doesn`t have UNORDERED and CONCURRENT
        System.out.println(collect);//[f, w, l, o]

        //#3: toConcurrentMap()
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors
                        .toConcurrentMap(String::length,
                                k -> k,
                                (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap

        //groupingByConcurrent()
        var ohMy1 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map1 = ohMy1
                .collect(Collectors
                        .groupingByConcurrent(String::length));
        System.out.println(map1); // {5=[lions, bears], 6=[tigers]}
    }
}