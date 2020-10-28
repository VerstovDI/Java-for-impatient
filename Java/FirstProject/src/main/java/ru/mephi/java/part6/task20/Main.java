package ru.mephi.java.part6.task20;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(repeat(2, List.of(1, 2, 3, 4, 5))));
    }

    @SafeVarargs public static final <T> T[] repeat(int n, T... objs) {
        List<T> resList = new ArrayList<>(n * objs.length);
        T[] result = (T[]) Array.newInstance(objs.getClass(), n * objs.length);
        for (int i = 0; i < n; i++) {
            resList.addAll(Arrays.asList(objs));
        }
        return (T[]) resList.toArray();
    }
}
