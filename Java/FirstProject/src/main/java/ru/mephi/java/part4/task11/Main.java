package ru.mephi.java.part4.task11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        printSomething("Hello, world!");
    }

    public static void printSomething(String message) throws ClassNotFoundException,
            NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> cl = Class.forName("java.lang.System");
        Field out = cl.getDeclaredField("out");
        Class<?> outClass = out.getType();
        Method println = outClass.getMethod("println", String.class);
        println.invoke(out.get(null), message);
    }
}
