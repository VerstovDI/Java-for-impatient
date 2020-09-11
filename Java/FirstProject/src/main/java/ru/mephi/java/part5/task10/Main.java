package ru.mephi.java.part5.task10;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int x = 10;
        System.out.println("factorial(" + x + ")=" + factorial(x));
    }

    public static int factorial(int x) {
        if (x == 1) {
            Exception ex = new Exception();
            StackTraceElement[] frames = ex.getStackTrace();
            Arrays.asList(frames).forEach(System.out::println);
            return x;
        }
        return (factorial(x - 1) * x);
    }
}
