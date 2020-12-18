package collection;

import java.util.concurrent.ConcurrentHashMap;

public class MemoryConsistencyError {
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

        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet())
            System.out.println(foodData.remove(key));
    }
}
