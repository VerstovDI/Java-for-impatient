package ru.mephi.java.part7.task15;


import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.IntFunction;

public class Task14Generalized {
    public static void main(String[] args) {
        /*List<Double> list = getImmutableList(Double::valueOf);
        System.out.println(list.get(100));*/

        IntFunction<Integer> intFunc = v -> v*v;
        ImmutableListViewAPI.ImmutableListView listView = ImmutableListViewAPI.getImmutableListView(15, intFunc);
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

    public static <E> List<E> getImmutableList(IntFunction<E> fn) {
        return new AbstractList<>() {
            @Override
            public E get(int index) {
                return fn.apply(index);
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
