package collection;

import java.util.HashMap;

public class MemoryConsistencyError {
    public static void main(String[] args) {
        //Single Thread
        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet()) {
            foodData.remove(key);
        }
    }
}
