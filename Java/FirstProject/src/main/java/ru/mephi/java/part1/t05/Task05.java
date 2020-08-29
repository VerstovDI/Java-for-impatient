package ru.mephi.java.part1.t05;

public class Task05 {
    public static void main(String[] args) {
        int int_val;
        double double_val = Integer.MAX_VALUE + 20.20;
        System.out.println("Situation #1:");
        int_val = (int) double_val;
        System.out.println("Double val.: " + double_val + " (more than max. possible int)\n"
                            + "Res. of cast from double to int: " + int_val + "\n");
        System.out.println("Situation #2:");
        int_val = (int) Math.round(double_val);
        System.out.println("Res. of cast from double to int (+Math.round): " + int_val);
    }
}
