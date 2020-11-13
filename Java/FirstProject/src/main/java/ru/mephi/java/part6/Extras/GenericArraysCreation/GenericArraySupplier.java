package ru.mephi.java.part6.Extras.GenericArraysCreation;

public interface GenericArraySupplier<T> {
    T[] get(int length);
}
