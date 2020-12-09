package ru.mephi.java.part7.task06;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<String, Set<Integer>> theMap1 = new HashMap<>();
        theMap1.put("element1", IntStream.of(1, 2, 3).boxed().collect(Collectors.toSet()));
        theMap1.put("element2", IntStream.of (3, 4, 7).boxed().collect(Collectors.toSet()));

        doSomething1(theMap1);
        Map<String, HashSet<Integer>> theMap2 = new HashMap<>();
        //doSomething1(theMap2); // !!!

        doSomething2(theMap1);
        doSomething2(theMap2); // !!!
    }

    public static void doSomething1(Map<String, Set<Integer>> someMap) {
        someMap.forEach( (k, v) -> {
            System.out.print(k + " ");
            v.forEach(val -> System.out.print(val + " "));
            System.out.println();
        } );
    }

    public static void doSomething2(Map<String, ? extends Set<Integer>> someMap) {
        someMap.forEach( (k, v) -> {
            System.out.print(k + " ");
            v.forEach(val -> System.out.print(val + " "));
            System.out.println();
        } );
    }
}
