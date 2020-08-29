package ru.mephi.java.part2.task16;


public class Task16 {
    public static void main(String[] args) {
        Queue1 q = new Queue1();
        q.add("Hello");
        q.add("Hi");
        q.add("bye");
        System.out.println(q.printQueue());
        System.out.println(q.remove());
        System.out.println(q.printQueue());
    }
}
