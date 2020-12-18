package collection;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ConcurrentClasses {
    public static void main(String[] args) {

        //ConcurrentHashMap
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant")); // 10

        //ConcurrentLinkedQueue
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek()); // 31
        System.out.println(queue.poll()); // 31

        //ConcurrentSkipListSet
        Set<String> gardenAnimals = new ConcurrentSkipListSet<>();
        gardenAnimals.add("rabbit");
        gardenAnimals.add("gopher");
        System.out.println(gardenAnimals
                .stream()
                .collect(Collectors.joining(","))); // gopher,rabbit

        //ConcurrentSkipListMap
        Map<String, String> rainForestAnimalDiet = new ConcurrentSkipListMap<>();
        rainForestAnimalDiet.put("panda", "bamboo");
        rainForestAnimalDiet.put("koala", "bamboo");
        rainForestAnimalDiet.entrySet()
                .stream()
                .forEach((e) -> System.out.println(e.getKey() + "-" + e.getValue())); // koala-bamboo

        //CopyOnWriteArrayList
        List<Integer> favNumbers =  new CopyOnWriteArrayList<>(List.of(4,3,42));
        for(var n: favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(9);
        }
        System.out.println();
        System.out.println("List: " +favNumbers + ",Size: " + favNumbers.size());

        /*favNumbers =  new ArrayList(List.of(4,3,42));
        for(var n: favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(9);//ConcurrentModificationException
        }*/

        Set<Character> favLetters = new CopyOnWriteArraySet<>(List.of('a','t'));
        for(char c: favLetters) {
            System.out.print(c+" ");
            favLetters.add('s');
        }
        System.out.println();
        System.out.println("Set: " + favLetters + ",Size: "+ favLetters.size());

        //LinkedBlockingQueue
        try {
            var blockingQueue = new LinkedBlockingQueue<Integer>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
        // Handle interruption
            e.printStackTrace();
        }

    }
}
