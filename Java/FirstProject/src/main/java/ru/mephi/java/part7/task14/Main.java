package ru.mephi.java.part7.task14;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = getImmutableList1(10);
        System.out.println(ints.get(30));
        System.out.println(ints.size());
        System.out.println(ints);
        //ImmutableListView listView = new ImmutableListView();
        List<Integer> ints2 = Collections.unmodifiableList(ints);
    }

    public static List<Integer> getImmutableList1(int n) {
        return new AbstractList<>() {
            private final int capacity = n;

            @Override
            public Integer get(int index) {
                if (index >= 0 && index <= capacity) {
                    return index;
                }
                return null;
            }

            @Override
            public int size() {
                return capacity;
            }
        };
    }
}
