package ru.mephi.java.part3.task08;

public class Task08 {
    public static void main(String[] args) {
        Runnable greeting1 = new Greeter(30, "Grigoriy!");
        Runnable greeting2 = new Greeter(25, "students!");
        Thread greetingThread1 = new Thread(greeting1);
        Thread greetingThread2 = new Thread(greeting2);
        greetingThread1.start();
        System.out.println(greetingThread1.getId());
        greetingThread2.start();
    }
}
