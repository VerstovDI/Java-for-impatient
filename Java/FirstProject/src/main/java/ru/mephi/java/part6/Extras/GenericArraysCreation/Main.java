package ru.mephi.java.part6.Extras.GenericArraysCreation;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {

    }

    public static <T> T[] getGenericArray1(Class<T> clazz, int sz) {
        return (T[]) Array.newInstance(clazz, sz);
    }

    public static <T> T[] getGenericArray2(int sz) {
        return (T[]) new Object[sz];
    }

    public static <T> T[] getGenericArray3(Class<T[]> clazz, int sz) {
        return clazz.cast(Array.newInstance(clazz.getComponentType(), sz));
    }

   /* public static <T> T[] getGenericArrayClass4(GenericArraySupplier<T> genArrSuppl, int sz) {
        genArrSuppl = new GenericArraySupplier<T>() {
            @Override
            public T[] get(int length) {
                return null;
            }
        }
        return ;
    }*/


}
