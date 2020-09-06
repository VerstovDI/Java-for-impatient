package ru.mephi.java.part5.task05;

import ru.mephi.java.part5.task01.Task01;

import java.io.IOException;

public class Main {
    private static final String basePath = Task01.getResourcesFilePath();
    private static final String filenameFrom = basePath.concat("task01.txt");
    private static final String filenameTo = basePath.concat("task05_output.txt");

    public static void main(String[] args) throws IOException {
        Task05 task05 = new Task05();
        System.out.println(task05.method2(filenameFrom, filenameTo));
        System.out.println(task05.method1(filenameFrom, filenameTo));
    }
}
