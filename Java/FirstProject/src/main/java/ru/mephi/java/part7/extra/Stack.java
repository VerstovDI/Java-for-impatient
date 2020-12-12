package ru.mephi.java.part7.extra;

import java.util.Collection;

public interface Stack<T> extends Collection<T> {
    T push(T el);
    T pop(T el);
    T peek();
}
