package ru.mephi.java.part4.task10;

import ru.mephi.java.part4.task09.Class2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printMethods(int[].class);
    }

    public static void printMethods(Class<?> cl) {
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " "
                                + m.getReturnType().getCanonicalName() + " "
                                + m.getName()
                                + Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass ();
        }
    }
}
