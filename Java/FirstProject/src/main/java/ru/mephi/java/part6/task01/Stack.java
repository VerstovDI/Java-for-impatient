package ru.mephi.java.part6.task01;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
    private static final long serialVersionUID = 4439393838282821L;
    private final ArrayList<E> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public E push(E element) {
        stack.add(element);
        return element;
    }

    public E pop() {
        E popElement = peek();
        remove();
        return popElement;
    }

    public E remove() {
        return stack.remove(stack.size() - 1);
    }

    public E peek() {
        int stackLength = stack.size();
        if (stackLength == 0) {
            throw new EmptyStackException();
        }
        return stack.get(stackLength - 1);
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
