package ru.mephi.java.part7.task16;

import ru.mephi.java.part7.task13.Cache;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Task15Caching {
    public static void main(String[] args) {
        List<Integer> list = getImmutableListCached(Integer::valueOf);
        list.get(100);
        System.out.println(list.get(100));
        //System.out.println(size());
    }

    public static <E> List<E> getImmutableListCached(IntFunction<E> fn) {
        return new AbstractList<>() {
            private final Cache<Integer, E> cache = new Cache<>(100);

            @Override
            public E get(int index) {
                if (cache.containsKey(index)) {
                    return cache.get(index);
                }
                E ret = fn.apply(index);
                cache.put(index, ret);
                return ret;
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
