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
    }
}
