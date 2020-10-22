package ru.mephi.java.part6.task02;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class TypedStack<E> {
    private static final long serialVersionUID = 23000038282821L;
    private E[] elementData;
    private int initialCapacity = 10;

    public TypedStack() {
    }

    public Stack() {
        elementData = new E[10];
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
