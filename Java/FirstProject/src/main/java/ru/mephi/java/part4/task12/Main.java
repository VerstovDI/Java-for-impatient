package ru.mephi.java.part4.task12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    private static final int NUMBER_OF_TESTS = 10000;
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Math.class.getMethod("sqrt", double.class);
        long startTime;
        long estimatedTime1 = 0;
        long estimatedTime2;
        long[] reflectionEstimatedTimes1 = new long[NUMBER_OF_TESTS];
        long[] reflectionEstimatedTimes2 = new long[NUMBER_OF_TESTS];
        long[] noReflectionEstimatedTimes = new long[NUMBER_OF_TESTS];

        for (int i = 0; i < 5; i++) {
            startTime = System.nanoTime();
            Math.sqrt(1500);
            estimatedTime2 = System.nanoTime() - startTime;
        }

        for (int i = 0; i < 5; i++) {
            startTime = System.nanoTime();
            m.invoke(Double.class, 1500);
            estimatedTime1 = System.nanoTime() - startTime;
        }

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            startTime = System.nanoTime();
            Math.sqrt(1500);
            estimatedTime2 = System.nanoTime() - startTime;
            noReflectionEstimatedTimes[i] = estimatedTime2;
        }

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            startTime = System.nanoTime();
            m.invoke(Double.class, 1500);
            estimatedTime2 = System.nanoTime() - startTime;
            reflectionEstimatedTimes1[i] = estimatedTime2;
        }

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            startTime = System.nanoTime();
            Math.class.getMethod("sqrt", double.class).invoke(Double.class, 1500);
            estimatedTime2 = System.nanoTime() - startTime;
            reflectionEstimatedTimes2[i] = estimatedTime2;
        }

        double resAverageTime1 = Arrays.stream(noReflectionEstimatedTimes).average().orElse(0);
        double resAverageTime2 = Arrays.stream(reflectionEstimatedTimes1).average().orElse(0);
        double resAverageTime3 = Arrays.stream(reflectionEstimatedTimes2).average().orElse(0);

        System.out.println(resAverageTime1 + "\n"
                + resAverageTime2 + "\n"
                + resAverageTime3);


        // Вызвать много раз одни, много раз другим (по 1 - 10), а потом много интераций (1000)
        // + пример: метод не один раз на все итерации, а один раз на каждую итерацию -> ...
    }
}
