package ru.mephi.java.part2.task10;

import java.util.ArrayList;
import java.util.Random;

class RandomNumbers {
    public static int nextInt(Random generator, int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }

    public static int randomElement(Random generator, int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return 0;
        }
        return arr[generator.nextInt(arr.length)];
    }

    public static int randomElement(Random generator, ArrayList<Integer> arrList) {
        if (arrList.isEmpty()) {
            System.out.println("Array is empty");
            return 0;
        }
        return arrList.get(generator.nextInt(arrList.size()));
    }
}
