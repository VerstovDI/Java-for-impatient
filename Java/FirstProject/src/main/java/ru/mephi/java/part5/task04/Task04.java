package ru.mephi.java.part5.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Task04 {
    private ArrayList<Double> currentArray = new ArrayList<>();
    private double currentSum;

    private int readValues(String filename) {
        if (filename == null || filename.isEmpty()) {
            return ErrorCodes.INVALID_FILE_NAME.getCode();
        }
        Scanner in;
        try {
            in = new Scanner(new File(filename));
            in.useLocale(Locale.US);
            while (in.hasNextDouble()) {
                currentArray.add(in.nextDouble());
            }
            return ErrorCodes.OK.getCode();
        } catch (FileNotFoundException e) {
            return ErrorCodes.FILE_NOT_FOUND.getCode();
        } catch (NumberFormatException numberFormatException) {
            return ErrorCodes.INCORRECT_NUMBER_FORMAT.getCode();
        }
    }

    public int sumOfValues(String filename) {
        return this.readValues(filename);
    }

    public int printResultOfSum(String filename) {
        if (sumOfValues(filename) == ErrorCodes.OK.getCode()) {
            System.out.println(this.currentSum);
            return ErrorCodes.OK.getCode();
        } else {
            if (this.readValues(filename) == ErrorCodes.FILE_NOT_FOUND.getCode()) {
                System.out.println("File wasn't found!");
                return ErrorCodes.FILE_NOT_FOUND.getCode();
            }
            if (this.readValues(filename) == ErrorCodes.INVALID_FILE_NAME.getCode()) {
                System.out.println("Invalid file name!");
                return ErrorCodes.INVALID_FILE_NAME.getCode();
            }
            if (this.readValues(filename) == ErrorCodes.INCORRECT_NUMBER_FORMAT.getCode()) {
                System.out.println("Invalid file number format!");
                return ErrorCodes.INVALID_FILE_NAME.getCode();
            }
            currentSum = 0;
            return ErrorCodes.NOT_OK.getCode();
        }
    }

    public double getCurrentSum() {
        return currentSum;
    }
}
