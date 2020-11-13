package ru.mephi.java.part6.Extras.GenericArraysCreation.UnsafeSignature;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        String[] arr1 = newArray1(String.class, 5);
        // OK. В данном случае нельзя написать первым аргументом метода не String.class
        System.out.println(arr1.getClass());

        // Class<?> не дает защиты на этапе компиляции, ровно как и Class
        // Можно ничего не подозревая написать:
        // String[] arrX = newArray2(Number.class, 10);
        // и ошибка будет получена уже на этапе компиляции
        String[] arr2 = newArray2(String.class, 5);
        System.out.println(arr2.getClass());
    }

    private static <T> T[] newArray1(Class<T> type, int len) {
        return (T[]) Array.newInstance(type, len);
    }

    private static <T> T[] newArray2(Class<?> type, int len) {
        return (T[]) Array.newInstance(type, len);
    }
}
