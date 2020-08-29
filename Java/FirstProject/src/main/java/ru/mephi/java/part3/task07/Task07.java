package ru.mephi.java.part3.task07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task07 {
    public static void main(String[] args) {
        ArrayList<String> arr = testArrList(new String[] { "Alex", "Clair", "Ben", "Eugene", "Daniel"});
        luckySort(arr, Comparator.comparingInt(String::length));
        arr.forEach(System.out::println);
    }

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        int j = 0;
        while (j < strings.size() - 1) {
            if (comp.compare(strings.get(j+1), strings.get(j)) > 0) {
                Collections.shuffle(strings);
                j = -1;
            }
            j++;
        }
    }

    public static ArrayList<String> testArrList(String[] strArr) {
        return new ArrayList<>(Arrays.asList(strArr));
    }
}
