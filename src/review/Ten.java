package review;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ten {
    public static void main(String[] args) {
        List<Integer> lions = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> tigers = new CopyOnWriteArrayList<>(lions);
        Set<Integer> bears = new ConcurrentSkipListSet<>();
        bears.addAll(lions);
        for (Integer item : tigers) tigers.add(4); // x1
        for (Integer item : bears) bears.add(5); // x2
        System.out.println(lions.size() + " " + tigers.size()
                + " " + bears.size());
    }
}
