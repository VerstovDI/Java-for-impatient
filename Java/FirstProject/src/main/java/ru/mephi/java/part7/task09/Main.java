package ru.mephi.java.part7.task09;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Integer> counters = new HashMap<>();

    public static void main(String[] args) {
        counters.put("Hello", 1);
        counters.put("Goodbye", 1);
        updateMap("Goodbye");
        System.out.println(counters.entrySet());

        // a

        // b
        // c
    }

    public static void updateMap(String word) {
        counters.merge(word, 1, Integer::sum);
    }

    public static void updateMapA(String word) {
        if (counters.containsKey(word)) {
            //counters.put(key, )
        }
    }

    public static void updateMapB(String word) {
        if (counters.containsKey(word)) {
            //counters.put(key, )
        }
    }

    public static void updateMapC(String word) {
        if (counters.containsKey(word)) {
            //counters.put(key, )
        }
    }

    public static void updateMapD(String word) {
        if (counters.containsKey(word)) {
            //counters.put(key, )
        }
    }
}
