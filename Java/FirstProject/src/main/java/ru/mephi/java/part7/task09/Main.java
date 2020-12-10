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
        updateMapA("Goodbye");
        System.out.println(counters.entrySet());
        // b
        updateMapB("Goodbye");
        System.out.println(counters.entrySet());
        // c
        updateMapC("Goodbye");
        System.out.println(counters.entrySet());
        // d
        updateMapD("Goodbye");
        System.out.println(counters.entrySet());
    }

    public static void updateMap(String word) {
        counters.merge(word, 1, Integer::sum);
    }

    public static void updateMapA(String word) {
        if (counters.containsKey(word)) {
            counters.compute(word,(s1, i) -> i = i + 1);
        } else {
            counters.put(word,1);
        }
    }

    public static void updateMapB(String word) {
        if (counters.get(word) != null) {
            counters.put(word, counters.get(word) + 1);
        }
    }

    public static void updateMapC(String word) {
        int n = counters.getOrDefault(word, 0);
        counters.put(word, ++n);
    }

    public static void updateMapD(String word) {
        Integer v;
        if ((v = counters.putIfAbsent(word, 1)) != null) {
            counters.put(word, v + 1);
        };
    }
}
