package ru.mephi.java.part1.t13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.Arrays;

public class task13 {
    public static void main(String[] args) {
        ArrayList<Integer> lottery_list = new ArrayList<>(49);  // Creation of ArrayList [1..49]
        for (int i = 0; i < 49; i++) {
            lottery_list.add(i, i+1);
        }

        int min = 1;  // Here: Random pick of 6 distinct numbers
        int max = 49;
        int diff = max - min;
        int pick_count = 6;
        int[] picked = new int[pick_count];  // Array of picked numbers
        Random generator = new Random();
        int random_num;
        for (int k = 0; k < pick_count; k++) {
            random_num = min + generator.nextInt(diff - k);
            picked[k] = lottery_list.get(random_num);
            lottery_list.remove(random_num);
        }

        lottery_list.sort(Comparator.reverseOrder());  // Sorting and printing the lottery_list
        System.out.println("The lottery list looks like:");
        for (Integer el : lottery_list) {
            System.out.print(el + " ");
        }
        System.out.println("\n");

        Arrays.sort(picked); // Sorting and printing the picked list
        System.out.println("The picked list looks like: ");
        for (int picked_el : picked) {
            System.out.print(picked_el + " ");
        }
    }

    /*public static ArrayList<Integer> lotteryCombination (int sz) {
        return
    }*/
}
