package ru.mephi.java.part7.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
        /*ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(6);*/
        Object[] ints = myStack.toArray();
        System.out.println(Arrays.toString(ints));
        //System.out.println(myStack.remove());
    }

    public static void initMyStack(MyStack<Integer> myStack) {
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack.push(i));
        }
    }
}
