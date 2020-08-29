package ru.mephi.java.part1.t11;

import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        // Input
        System.out.println("Please, enter a string:");
        Scanner sc = new Scanner(System.in);
        String str_input = sc.nextLine();
        String str_not_ascii = str_input.replaceAll("[\\x00-\\x7F]*", "");
        System.out.println("String without ASCII characters: " + str_not_ascii);
        for (char c : str_not_ascii.toCharArray()) {
            int code = (int) c;
            System.out.println("Character: " + c + " ~ Unicode: " + "\\u" + Integer.toHexString(code));
        }
    }
}
