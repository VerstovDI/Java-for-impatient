package ru.mephi.java.part1.t16;

public class task16 {
    public static void main(String[] args) {
        System.out.println("One argument (5): " + average(5));
        System.out.println("Multiple arguments (5,3,4): " + average(5, 3,4));
    }

    public static double average (double  arg1, double... argsN) {
        double sum = arg1;
        for (double arg : argsN) {
            sum += arg;
        }
        return argsN.length == 0 ? sum : sum / (argsN.length + 1);
    }
}
