package ru.mephi.java.part7.task14;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*List<Integer> ints = getImmutableList1(10);
        System.out.println(ints.get(30));
        System.out.println(ints.size());
        System.out.println(ints);
        //ImmutableListViewAPI listView = new ImmutableListViewAPI();
        List<Integer> ints2 = Collections.unmodifiableList(ints);*/
        //ArrayList

        ImmutableListViewAPI.ImmutableListView listView = ImmutableListViewAPI.getImmutableListView(15);
        System.out.println("Full list:");
        listView.forEach(System.out::println);

        System.out.println("Size:");
        System.out.println(listView.size());

        System.out.println("Is empty?");
        System.out.println(listView.isEmpty());

        System.out.println("Sublist from 4 to 15:");
        listView.subList(4,15).forEach(System.out::println);
        System.out.println("Sublist from 1 to 2:");
        listView.subList(1,2).forEach(System.out::println);
        System.out.println("Get element with index 5:");
        System.out.println(listView.get(5));
        System.out.println("Iterator test:");
        Iterator<Integer> it = listView.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("List iterator test:");
        ListIterator<Integer> listIterator = listView.listIterator(5);
        while (listIterator.hasNext()) {
            System.out.println("Curr val " + listIterator.next());
            System.out.println("Prev index " + listIterator.previousIndex());
        }
        System.out.println(listView.add(50));
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
