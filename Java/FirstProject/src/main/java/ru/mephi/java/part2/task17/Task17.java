package ru.mephi.java.part2.task17;

public class Task17 {
    public static void main(String[] args) {
        Queue2 q = new Queue2();
        q.printQueue();
        q.add("Hello");
        q.add("Hi");
        q.add("bye");
        q.printQueue();
        q.remove();
        q.printQueue();
        Queue2.Iterator newIterator = q.iterator();

        while (newIterator.hasNext()) {
            System.out.println(newIterator.next());
        }

        Queue2 q2 = new Queue2();
        Queue2.Iterator itt = q2.iterator();
    }
}
