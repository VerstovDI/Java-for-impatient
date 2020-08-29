package ru.mephi.java.part1.t01;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        // Input integer with check procedure (is it an int?)
        Scanner sc = new Scanner(System.in);
        int inputInt;
        while (true) {
            System.out.print("Enter here the integer, please -->: ");
            if (sc.hasNextInt()) {
                inputInt = sc.nextInt();
                break;
            } else {
                System.out.println("Incorrect input.");
                sc.next();
            }
        }

        // Output in the neccessary formats
        String bin_s = Integer.toBinaryString(inputInt);
        String oct_s = Integer.toOctalString(inputInt);
        String hex_s = Integer.toString(inputInt, 16);
        System.out.printf("---Solution---\n\tBinary: %s;\n\tOctal: %s;\n\tHexadecimal: %s.\n\n", bin_s, oct_s, hex_s);

        // Printing the reciprocal as a hexadecimal floating-point number
        float reciprocal;
        reciprocal = 1.0f / inputInt;
        System.out.printf("Printing the reciprocal as a hexadecimal floating-point number:\n\tResult: %s", Float.toHexString(reciprocal));
    }
}
