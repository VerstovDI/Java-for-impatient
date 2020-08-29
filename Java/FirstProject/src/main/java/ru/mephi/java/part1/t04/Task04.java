package ru.mephi.java.part1.t04;

public class Task04 {
    public static void main(String[] args) {
        double min_double = 0.0;
        System.out.println("[Using Math.nextUp] The smallest positive double value: " + Math.nextUp(min_double));
        System.out.println("[Using Double.MIN_VALUE]: " + Double.MIN_VALUE);
        double max_double = 1.0 / 0.0;
        System.out.println("-----------------");
        System.out.println("[Using Math.nextDown]: The largest positive double value: " + Math.nextDown(max_double));
        System.out.println("[Using Double.MAX_VALUE]: " + Double.MAX_VALUE);
    }
}
