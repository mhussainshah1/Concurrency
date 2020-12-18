package collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeleteWhileLooping {
    public static void main(String[] args) {
        //Single Thread
        /*
        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet()) {
            System.out.println(foodData.remove(key));
        }
        */

        //ConcurrentHashMap
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet())
            System.out.println(foodData.remove(key));

        //CopyOnWriteArrayList - Use alot of memory
        List<String> birds = new CopyOnWriteArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        for (String bird : birds)
            birds.remove(bird);
        System.out.print(birds.size()); // 0

        //Alternatively,
        birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        var iterator = birds.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.print(birds.size()); // 0

        //Synchronized Collections Methods
        var foodData1 = new HashMap<String, Object>();
        foodData1.put("penguin", 1);
        foodData1.put("flamingo", 2);
        var synFoodData = Collections.synchronizedMap(foodData1);
        for(String key: synFoodData.keySet())
            synFoodData.remove(key);
    }
}
