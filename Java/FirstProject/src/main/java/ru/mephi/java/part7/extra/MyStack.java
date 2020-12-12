package ru.mephi.java.part7.extra;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class MyStack<T> implements Stack<T> {
    private int size = 0;
    private int capacity = 10;
    private Object[] elements;

    public MyStack() {
        elements = new Object[capacity];
    }

    private void ensureCapacity() {
        int newSize = capacity * 3/2;
        capacity = newSize;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public T push(T el) {
        if (size == capacity) {
            ensureCapacity();
        }
        elements[size] = el;
        size++;
        return el;
    }

    @Override
    public T pop(T el) {
        T topEl = peek();
        remove(el);
        return topEl;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elements[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object el : elements) {
            if (o.equals(el)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(@NotNull T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        } // TODO: доделать
        return a;
    }

    @Override
    public boolean add(T el) {
        push(el);
        return true;
    }

    @Override
    public boolean remove(Object o) {
       /* if (size != 0) {
            elements[size-1] = null;
            return false;
        }*/ // TODO: допилить
        return true;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {

        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size-1; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    
    private class MyStackIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    @Override
    public String toString() {
        return super.toString(); // TODO:
    }
}
