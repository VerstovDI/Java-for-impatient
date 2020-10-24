package ru.mephi.java.part6.task08;

public class Main {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(3,4);
        // TODO: зачем <? super E>
        // TODO: <E extends Comparable> VS <E extends Comparable<E> VS <E extends Comparable<? super E>
        System.out.println(p.max());
        System.out.println(p.min());
    }
}
