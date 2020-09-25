package ru.mephi.java.part5.task04;

public class DoCalculation {
    private static final int totalSum = 150000;
    private double result;

    public int getPercentage(Task04 task04, String fileName) {
        double result;
        if (task04.sumOfValues(fileName) == ErrorCodes.OK.getCode()) {
            result = task04.getCurrentSum()/totalSum * 100;
            this.result = result;
            return ErrorCodes.OK.getCode();
        } else {
            this.result = 0;
            return ErrorCodes.NOT_OK.getCode();
        }
    }

    public double getResult() {
        return result;
    }
}
