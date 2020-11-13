package ru.mephi.java.part6.Extras.GenericArraysCreation.TArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

public class Main<K> {
    private K[] someTypedArr;

    public static void main(String[] args) {
    }

    @SuppressWarnings("unchecked")
    public Main(Class<K> clazz, int sz) {
        // Way #1
        someTypedArr = getGenericArray1(clazz, sz);

        // Way #2
        GenericArraySupplier<K> genericArraySupplier
                = length -> (K[]) new Object[length];
        someTypedArr = genericArraySupplier.get(sz);
    }

    public K[] getSomeTypedArr() {
        return someTypedArr;
    }

    // Way #1
    @SuppressWarnings("unchecked")
    private static <T> T[] getGenericArray1(Class<T> type, int sz) {
        return (T[]) Array.newInstance(type, sz);
    }
}
