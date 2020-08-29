package ru.mephi.java.part3.Theory1;

public interface IntSorter {

    int[] getSorted(int[] arr);

    default void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

}
