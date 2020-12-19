package review;

import java.util.concurrent.Callable;

public class Eighteen {
    public static void main(String[] args) {
//          a -> {return 10;}
//         () -> {String s = "";};
        Callable c1 = () -> 5;
//         () -> {return null}
        c1 = () -> "The" + "Zoo";
//         (int count) -> count+1;
        c1 = () -> {
            System.out.println("Giraffe");
            return 10;
        };
    }
}
