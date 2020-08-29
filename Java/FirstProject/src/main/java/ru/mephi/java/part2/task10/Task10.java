package ru.mephi.java.part2.task10;

import java.util.ArrayList;
import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = {22, 30, 41};
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(55);
        arrList.add(60);
        System.out.println(RandomNumbers.randomElement(rnd, arr));
        System.out.println(RandomNumbers.randomElement(rnd, arrList));
        }
}
