package ru.mephi.java.part6.Extras.GenericArraysCreation.СoContrVariance;

import java.util.*;

public class MyArrayList<T> extends ArrayList<T> {
    int size;
    Object[] elementData;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArrayList(Collection<? extends T> collection) {
        Object[] a = collection.toArray();
        if ((size = a.length) != 0) {
            if (collection.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            // replace with empty array.
            elementData = EMPTY_ELEMENTDATA;
        }
    }

    @SuppressWarnings("unchecked")
    public void mySort(Comparator<T> c) {
        final int expectedModCount = modCount;
        Arrays.sort((T[]) elementData, 0, elementData.length, c);
    }
}
