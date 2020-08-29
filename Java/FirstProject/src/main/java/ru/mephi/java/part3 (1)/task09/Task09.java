package ru.mephi.java.part3.task09;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ru.mephi.java.part1.t10.Task10.genRandStr;


public class Task09 {
    public static void main(String[] args) {
        /*Thread tMain = Thread.currentThread();
        System.out.println("~~~Together:~~~");
        testRunTogether();*/
        System.out.println("~~~In order:~~~");
        testRunInOrder();
    }

    public static void testRunTogether() {
        runTogether(createRandomTasks());
    }

    public static void testRunInOrder() {
        runInOrder(createRandomTasks());
    }

    public static Runnable[] createRandomTasks() {
        Random rnd = new Random();
        int constSz = 2 + rnd.nextInt(7);
        Runnable[] runnableArr = new RunnableTaskClass[constSz];
        for (int j = 0; j < constSz; j++) {
            runnableArr[j] = new RunnableTaskClass(genRandStr(1+rnd.nextInt(constSz+5)), rnd.nextInt(10));
        }
        return runnableArr;
    }

    public static Thread[] createThreads(Runnable... tasks) {
        Thread[] threads = new Thread[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            threads[i] = new Thread(tasks[i], String.format("task#%d", i));
        }
        return threads;
    }

    public static void startThreads(Thread[] threads) {
        for (Thread t: threads) {
            t.start();
        }
    }

    public static void runTogether(Runnable... tasks) {
        Thread[] threads = createThreads(tasks);
        startThreads(threads);
    }

    public static void runInOrder(Runnable... tasks) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (Runnable task : tasks) {
            service.submit(task);
        }
        service.shutdown();
    }
}
