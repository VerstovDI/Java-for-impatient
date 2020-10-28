package ru.mephi.java.part6.task18;

import java.util.function.IntFunction;

public class CustomArrays {
    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) {
            result[i] = obj;
        }
        return result;
    }
}
