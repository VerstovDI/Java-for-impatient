package ru.mephi.java.part2.Queue3;

public class ExtraTask {
    public static void main(String[] args) {
        Queue3 q3 = new Queue3();
        testCase(q3);
    }

    public static void testCase(Queue3 q) {
        for (short j = 0; j < 26; j++) {
            q.add(String.valueOf((char)(j + 65)));
        }
        System.out.format("~ Added some symbols of Eng alphabet: ");
        q.printQueue();
        System.out.format("[INFO] Current capacity: %s;%n[INFO] Current size: %s;%n", q.capacity(), q.size());
        System.out.println(q.remove());
        q.remove();
        System.out.println("~ Removed two elements from head: ");
        q.printQueue();
        System.out.format("[INFO] Current capacity: %s;%n[INFO] Current size: %s;%n", q.capacity(), q.size());
        System.out.println("~ Add one more element ~");
        //q.add("ADD_AFTER_REMOVE");
        System.out.format("Queue: ");
        q.printQueue();
    }
}
