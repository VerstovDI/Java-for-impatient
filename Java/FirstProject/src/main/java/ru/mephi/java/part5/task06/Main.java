package ru.mephi.java.part5.task06;

import ru.mephi.java.part5.task01.Task01;

public class Main {
    private static final String pathToFile = Task01.getResourcesFilePath().concat("task06.txt");

    public static void main(String[] args) {
        Task06 task06 = new Task06();
        System.out.println(task06.readSomething1(pathToFile));
        System.out.println(task06.readSomething2(pathToFile));
        System.out.println(task06.readSomething3(pathToFile));
    }
}
