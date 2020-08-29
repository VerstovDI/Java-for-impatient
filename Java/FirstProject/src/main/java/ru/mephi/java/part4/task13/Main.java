package ru.mephi.java.part4.task13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // передаём method
        printTableOfDoubleValuesForStaticMethod(Math.class.getMethod("sqrt", double.class), 1,9, 2);
        System.out.println();
        printTableOfDoubleValuesForStaticMethod(Double.class.getMethod("toHexString", double.class), 1,9, 2);
        System.out.println();
        // передаём DoubleFunction<Object>
        printTableOfDoubleValuesForStaticMethod2(Math::sqrt, 1,9, 2);
        System.out.println();
        printTableOfDoubleValuesForStaticMethod2(Double::toHexString, 1,9, 2);
        System.out.println();
    }


    public static void printTableOfDoubleValuesForStaticMethod(Method method, double lowerBound, double upperBound, double stepSize)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || !Modifier.isStatic(method.getModifiers())) {
            throw new IllegalArgumentException();
        }
        System.out.println("Method: " + method.getDeclaringClass().getCanonicalName() + "." + method.getName());
        System.out.println(method.getDeclaringClass().getCanonicalName() + "." + method.getName());
        for (double value = lowerBound; value <= upperBound; value += stepSize) {
            Object result = method.invoke(method.getDeclaringClass(), value);
            System.out.println("Current value: " + value + " -> result of invoke the function: " + result);
        }
    }

    public static void printTableOfDoubleValuesForStaticMethod2(DoubleFunction<Object> method, double lowerBound, double upperBound, double stepSize)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        System.out.println("DoubleFunction<Object>");
        for (double value = lowerBound; value <= upperBound; value += stepSize) {
            Object result = method.apply(value);
            System.out.println("Current value: " + value + " -> result of invoke the function: " + result);
        }
    }
}
