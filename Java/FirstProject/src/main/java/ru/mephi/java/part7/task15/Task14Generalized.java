package ru.mephi.java.part7.task15;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Task14Generalized {
    public static void main(String[] args) {
        List<Double> list = getImmutableList(Double::valueOf);
        System.out.println(list.get(100));
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
