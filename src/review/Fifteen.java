package review;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fifteen {
    public static void main(String[] args) {
        var cats = Stream.of("leopard", "lynx", "ocelot", "puma").parallel();
        var bears = Stream.of("panda", "grizzly", "polar").parallel();
        var data =
                Stream.of(cats, bears)
                        .flatMap(s -> s)
                        .collect(Collectors.groupingByConcurrent(
                                s -> !s.startsWith("p")));
        System.out.println(data + "\n" + data.get(false).size()+ " " + data.get(true).size());
    }
}
