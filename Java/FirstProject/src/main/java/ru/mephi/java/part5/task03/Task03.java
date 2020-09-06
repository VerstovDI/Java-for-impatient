package ru.mephi.java.part5.task03;

import ru.mephi.java.part5.task01.Task01;
import ru.mephi.java.part5.task02.Task02;

import java.io.IOException;

public class Task03 {
    public static void main(String[] args) throws IOException {
        printSumOfDoublesInFile(Task01.getResourcesFilePath() + "task01.txt");
    }

    public static void printSumOfDoublesInFile(String filename) throws IOException {
        System.out.println(Task02.sumOfValues2(filename));
    }
}
