package ru.mephi.java.part1.t03;

import java.util.ArrayList;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        // Input method
        ArrayList<Integer> inputInts = input();

        // Search of the greatest, using if-condition
        int res = maximumOfInts(inputInts);

        // Repetition with Math.max
        System.out.println("\n[Result] The largest integer is " + res);
    }

    public static ArrayList<Integer> input() {
        int i = 0;
        String tmp;
        ArrayList<Integer> resIntList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("Integer #%d -->: ", i);
            tmp = sc.nextLine();
            if (tmp.equals("")) {
                System.out.println("[OK] Input ended...");
                break;
            }
            resIntList.add(Integer.parseInt(tmp));
            i++;
        }
        return resIntList;
    }

    public static int maximumOfInts(ArrayList<Integer> argInts) {
        int maximum = argInts.get(0);
        for (Integer el : argInts) {
            if (maximum < el) { maximum = el; }
        }
        return maximum;
    }
}
