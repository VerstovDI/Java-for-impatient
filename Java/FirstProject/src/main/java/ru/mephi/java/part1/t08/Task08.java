package ru.mephi.java.part1.t08;

import java.util.ArrayList;
import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        // Input
        System.out.println("Please, enter a string:");
        String outStr = inputStr();

        // Search for all substrings
        System.out.println("The substrings are:");
        ArrayList<String> strArr = findAllSubstrings(outStr);
        System.out.println(strArr);
    }

    public static ArrayList<String> findAllSubstrings (String str) {
        // Finding all substrings
        ArrayList<String> strArr = new ArrayList<>();
        int k = 0;
        strArr.add(str.substring(0, str.length()-1));
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                strArr.add(str.substring(i, j));
            }
        }
        return strArr;
    }

    public static String inputStr() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
