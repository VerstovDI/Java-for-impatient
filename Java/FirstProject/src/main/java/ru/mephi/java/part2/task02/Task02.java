package ru.mephi.java.part2.task02;

import java.util.Scanner;
import java.util.Random;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputInt;
        do {
            System.out.println("Again: ");
            inputInt = sc.nextInt();
        } while (inputInt != -1);
        /*
            Scans the next token of the input as an int.
        This method will throw InputMismatchException if the next token cannot be translated into a valid int value as described below.
            If the translation is successful, the scanner advances past the input that matched.
        This tells that the state of the scanner is altered after calling the method. So this makes nextInt a mutator.
            Therefore, ScannerObj.nextInt() is both a mutator(!!!!) and an accessor.
         */
        Random rnd = new Random();
        System.out.println(rnd.nextInt(5));
        // RandomObj.nextInt() also mutator (look code)
    }
}
