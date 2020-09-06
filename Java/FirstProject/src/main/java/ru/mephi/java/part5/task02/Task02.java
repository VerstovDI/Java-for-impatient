package ru.mephi.java.part5.task02;

import ru.mephi.java.part5.task01.Task01;

import java.io.IOException;

public class Task02 {
    public static void main(String[] args) throws IOException {
        double sum = sumOfValues1(Task01.getResourcesFilePath() + "task01.txt");
        //System.out.println(sumOfValues(Task01.getResourcesFilePath() + "task01.txt"));
    }

    public static double sumOfValues1(String filename) throws IOException {
        double resSum = 0;
        resSum = Task01.readValues(filename)
                .stream()
                .mapToDouble(d -> d)
                .sum();
        return resSum;
    }

    public static double sumOfValues2(String filename) throws IOException {
        double resSum = 0;
        resSum = Task01.readValues1(filename)
                .stream()
                .mapToDouble(d -> d)
                .sum();
        return resSum;
    }


}
