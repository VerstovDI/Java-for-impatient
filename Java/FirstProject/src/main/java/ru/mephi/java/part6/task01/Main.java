package ru.mephi.java.part6.task01;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        System.out.println(integerStack.isEmpty());
        //System.out.println(integerStack.pop());
        System.out.println(integerStack.push(5));
        System.out.println(integerStack.isEmpty());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.isEmpty());
        System.out.println(integerStack.push(-2));
        System.out.println(integerStack.push(100));
        System.out.println(integerStack.pop());
        System.out.println(integerStack.isEmpty());
        System.out.println(integerStack.push(100));
        System.out.println(integerStack.push(101));
        System.out.println(integerStack.push(102));
        System.out.println(integerStack.push(103));
        System.out.println(integerStack.push(104));
        System.out.println(integerStack.push(105));
        System.out.println(integerStack.push(106));
        System.out.println(integerStack.push(107));
        System.out.println(integerStack.push(108));
        System.out.println(integerStack.push(109));
        System.out.println(integerStack.pop());

    }
}
