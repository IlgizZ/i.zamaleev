package ru.kpfu.itis.group11408.zamaleev.class1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ильгиз on 07.04.2015.
 */
public class CollectionExample {
    public CollectionExample() {

    }

    public static void main(String[] args){
        Map<Integer, List<String>> map = new CollectionExample().getTestMap();
        map.forEach((k, v)-> System.out.println("Key: " + k + ", value: " + v));
    }

    private Map<Integer, List<String>> getTestMap(){
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            List<String> list = Arrays.asList("I", "am", "number",
                    String.valueOf(i));
            map.put(i, list);
        }
        return map;
    }
}
