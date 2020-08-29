package ru.mephi.java.part4.task12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Math.class.getMethod("sqrt", double.class);
        long startTime;
        long estimatedTime1;
        long estimatedTime2;

        startTime = System.nanoTime();
        Math.sqrt(1500);
        estimatedTime2 = System.nanoTime() - startTime;
        System.out.println(estimatedTime2);

        startTime = System.nanoTime();
        m.invoke(Double.class, 1500);
        estimatedTime1 = System.nanoTime() - startTime;
        System.out.println(estimatedTime1);

        // Вызвать много раз одни, много раз другим (по 1 - 10), а потом много интераций (1000)
        // + пример: метод не один раз на все итерации, а один раз на каждую итерацию -> ...
        System.out.println("С помощью рефлексии получилось дольше приблизительно в " + estimatedTime1/estimatedTime2 + " раз");
    }
}
