package ru.mephi.java.part5.task12;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // to disable assertions:
        // VM Options (ctrl+shift+A -> VM -> edit custom VM options -> -da instead -ea)
        Task12 task12 = new Task12();
        int arr[] = new int[Integer.MAX_VALUE/10];
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(Integer.MAX_VALUE);
        }
        for (int i = 0; i < 20; i++) {
            task12.minAssert(arr);
        }
        for (int i = 0; i < 20; i++) {
            task12.minWithoutAssert(arr);
        }
        long[] resultWithAssert = new long[50];
        long[] resultWithout = new long[50];
        int res;
        long start;
        long finish;
        for (int i = 0; i < 50; i++) {
            start = System.nanoTime();
            res = task12.minAssert(arr);
            finish = System.nanoTime();
            resultWithAssert[i] = finish - start;
        }
        for (int i = 0; i < 50; i++) {
            start = System.nanoTime();
            res = task12.minWithoutAssert(arr);
            finish = System.nanoTime();
            resultWithout[i] = finish - start;
        }
        System.out.println("Min value with assertion =  " + Arrays.stream(resultWithAssert).average());
        System.out.println("Min value without assertion = " + Arrays.stream(resultWithout).average());
    }
}
