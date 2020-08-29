package ru.mephi.java.part3.task13;

public class Task13 {
    public static void main(String[] args) {
        Runnable r = orderRunnable(test());
        r.run();
    }

    public static Runnable orderRunnable(Runnable[] runnableArr) {
        return () -> {
            for (Runnable r : runnableArr) {
                r.run();
            }
        };
    }

    public static Runnable[] test() {
        return new Runnable[] { new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, my friend!");
            }},
                () -> System.out.println("Goodbye, my friend!")
        };
    }
}
