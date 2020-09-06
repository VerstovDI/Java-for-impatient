package ru.mephi.java.part5.task05;

import java.io.IOException;

public class Main {
    private static final String filenameFrom = "task01.txt";
    private static final String filenameTo = "task05_output.txt";

    public static void main(String[] args) throws IOException {
        Task05 task05 = new Task05();
        System.out.println(task05.method1(filenameFrom, filenameTo));
        System.out.println(task05.method2(filenameFrom, filenameTo));
    }
}
