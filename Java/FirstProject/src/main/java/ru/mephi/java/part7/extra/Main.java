package ru.mephi.java.part7.extra;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Stack
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println("Пуст ли стек? (true): " + myStack.isEmpty());
        System.out.println("Сколько элементов? (0): " + myStack.size());
        initMyStack(myStack);
        System.out.println("Сколько элементов? (10): " + myStack.size());
        myStack.add(10);
        System.out.println("Сколько элементов? (11): " + myStack.size());
        Object[] ints = myStack.toArray();
        System.out.println("Метод toArray(): " + Arrays.toString(ints));
        System.out.println("Метод peek() (10): " + myStack.peek());
        System.out.println("Метод contains(5) (true): " + myStack.contains(5));
        System.out.println("Метод contains(11) (false): " + myStack.contains(11));
        System.out.println("Метод remove(12): " + myStack.remove(12));
        System.out.println("Метод remove(6): " + myStack.remove(6));
        System.out.println("Метод pop(): " + myStack.pop());
        System.out.println(Arrays.toString(myStack.toArray()));
        //myStack.clear();
        //System.out.println(Arrays.toString(myStack.toArray()));

        //
        Iterator<Integer> stackIt = myStack.iterator();
        System.out.println("iterator" + Arrays.toString(myStack.toArray()));
        while (stackIt.hasNext()) {
            System.out.println(stackIt.next());
        }
        stackIt.next();
    }

    public static void initMyStack(MyStack<Integer> myStack) {
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack.push(i));
        }
    }
}
