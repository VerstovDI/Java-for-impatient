package ru.mephi.java.part6.Extras.GenericArraysCreation.TArray;

@FunctionalInterface
public interface GenericArraySupplier<T> {
    T[] get(int length);
}
