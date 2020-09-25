package ru.mephi.java.part5.task04;

import ru.mephi.java.part5.task01.Task01;

public class Main {
    public static void main(String[] args) {
        Task04 task04 = new Task04();
        String stringPath = Task01.getResourcesFilePath() + "task01.txt";
        if (task04.printResultOfSum(stringPath) == ErrorCodes.NOT_OK.getCode()) {
            System.out.println("Some error during...");
        }
        DoCalculation doCalculation = new DoCalculation();

        if (task04.sumOfValues(stringPath) == ErrorCodes.OK.getCode()) {
            int codeResult = doCalculation.getPercentage(task04, stringPath);
            if (codeResult == ErrorCodes.NOT_OK.getCode()) {
                System.out.println("Can't calculate percent because of error!");
            }
            if (codeResult == ErrorCodes.OK.getCode()) {
                System.out.println(doCalculation.getResult());
            }
        }
    }
}
