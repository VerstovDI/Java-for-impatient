package ru.mephi.java.part1.t07;

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        // Input of 2 short numbers
        Scanner sc = new Scanner(System.in);
        System.out.print("Number #1 -->: ");
        short sh1 = (short) sc.nextInt();
        System.out.print("Number #2 -->: ");
        short sh2 = (short) sc.nextInt();

        System.out.println("Number #1 (short): " + sh2 + "; Number #1 (int):" + (0x0000FFFF & sh1));
        System.out.println("Number #2 (short): " + sh2 + "; Number #2 (int):" + (0x0000FFFF & sh1));

        int sum = sumUShort(sh1, sh2);
        int diff = diffUShort(sh1, sh2);
        int prod = multipleUShort(sh1, sh2);
        int quot = divideUShort(sh1, sh2);
        int remainder = remainderUShort(sh1, sh2);
        System.out.printf("Unsigned sum: %d\nUnsigned difference: %d\nUnsigned product: %d" +
                "\nUnsigned quotient: %d\nUnsigned remainder: %d\n", sum, diff, prod, quot, remainder);
    }

    public static int multipleUShort (short a, short b) {
        //int prod;
        //prod = (int) a * b;
        return (0x0000FFFF & a) * (0x0000FFFF & b);
    }

    public static int sumUShort (short a, short b) {
        //int res;
        //res = (int) a + b;
        return (0x0000FFFF & a) + (0x0000FFFF & b);
    }

    public static int diffUShort (short a, short b) {
        //int res;
        //res = Math.abs(a - b);
        return (0x0000FFFF & a) < (0x0000FFFF & b) ?
                (0x0000FFFF & b) - (0x0000FFFF & a) : (0x0000FFFF & a) - (0x0000FFFF & b) ;
    }

    public static int divideUShort (short a, short b) {
        int res;
        if (b == 0) {
            System.out.println("Division by a zero. Returned -1");
            return -1;
        }
        res = (0x0000FFFF & a) / (0x0000FFFF & b);
        return res;
    }
    public static int remainderUShort (short a, short b) {
        //int res;
        //res = (int) a % b;
        return (0x0000FFFF & a) % (0x0000FFFF & b);
    }
}
