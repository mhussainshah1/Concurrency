package parallelStream;

import java.util.List;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

public class Create {
    public static void main(String[] args) {
        //#1 - on existing Stream
        Stream<Integer> s1 = List.of(1, 2).stream();
        Stream<Integer> s2 = s1.parallel();

        //#2 - on Collection
        Stream<Integer> s3 = List.of(1, 2).parallelStream();

        //concat() - if either is parallel convert result into parallel
        Stream<Integer> concat = Stream.concat(Stream.of(3), s2); //
        if (concat.isParallel()) {
            concat.forEach(System.out::println);
        }
        //flatmap() - convert any stream into single stream
        Stream<String> stringStream =
                Stream.of(
                        List.of("one").parallelStream(),
                        List.of("two").parallelStream(),
                        List.of("three").parallelStream()).flatMap(BaseStream::parallel);
        if(!stringStream.isParallel()){
            stringStream.forEach(System.out::println);
        }
    }
}

