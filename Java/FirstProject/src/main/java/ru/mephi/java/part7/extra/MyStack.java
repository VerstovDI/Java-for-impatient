package ru.mephi.java.part7.extra;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<T> implements Stack<T> {
    private ArrayList<T> dataArray;

    public MyStack() {
        dataArray = new ArrayList<>();
    }

    @Override
    public T push(T el) {
        dataArray.add(el);
        return el;
    }

    @Override
    public T pop() {
        T removedEl = dataArray.get(dataArray.size()-1);
        dataArray.remove(dataArray.get(dataArray.size()-1));
        return removedEl;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return dataArray.get(dataArray.size()-1);
    }

    @Override
    public int size() {
        return dataArray.size();
    }

    @Override
    public boolean isEmpty() {
        return dataArray.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return dataArray.contains(o);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return dataArray.iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return dataArray.toArray();
    }

    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(@NotNull E[] a) {
        return (E[]) dataArray.toArray(new Object[0]);
    }

    @Override
    public boolean add(T el) {
        push(el);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return dataArray.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return dataArray.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return dataArray.addAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return dataArray.removeAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return dataArray.retainAll(c);
    }

    @Override
    public void clear() {
        dataArray.clear();
    }
}
