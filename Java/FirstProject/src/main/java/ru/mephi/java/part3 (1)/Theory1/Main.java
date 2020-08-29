package ru.mephi.java.part3.Theory1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 4, 6, 2, 9};
        InsertionSort sortableIns = new InsertionSort();
        SelectionSort sortableSel = new SelectionSort();
        ShellSort sortableShell = new ShellSort();
        int[] arr2 = new int[] {3, 1, 4, 6, 2, 9, 7, 7,
                6, 51, 231, 0, -3, 44, 23,
                17, 2, 23, 55, 901, 323, 12,
                10, 11, 8, 5, 19, 26, 23, 140,
                1043, 1392, 122, 22, 322, 431,
                106, 2350, 505, 293, 220, 231,
                868, 7564, 555, 432, 434, 54};
        polymorph(arr2, sortableIns, sortableSel, sortableShell);
    }

    public static void polymorph(int[] arr, IntSorter... intSorters) {
        int[] resArr = new int[8];
        long startTime;
        for (int i = 0; i < intSorters.length; i++) {
            startTime = System.nanoTime();
            resArr = intSorters[i].getSorted(arr);
            System.out.println("Sort time: " + (System.nanoTime() - startTime) + "ns");
            System.out.println("Sorted array: " + Arrays.toString(resArr));
        }
    }
}
