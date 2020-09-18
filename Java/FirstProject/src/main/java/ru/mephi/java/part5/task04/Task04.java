package ru.mephi.java.part5.task04;

import java.io.File;
import java.io.FileNotFoundException;
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
        } catch (FileNotFoundException e) {
            return ErrorCodes.FILE_NOT_FOUND.getCode();
        }
        return ErrorCodes.OK.getCode();
    }

    private int sumOfValues(String filename) {
        currentSum = currentArray.stream().mapToDouble(d -> d).sum();
        return this.readValues(filename);
    }

    public int printResultOfSum(String filename) {
        System.out.println(sumOfValues(filename));
        return sumOfValues(filename);
    }
}
