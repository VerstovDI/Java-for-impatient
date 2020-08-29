package ru.mephi.java.part3.task09;

public class RunnableTaskClass implements Runnable {
    private String uniqueMsg = "default";
    private int cnt = 1;

    public RunnableTaskClass(String msg, int cnt) {
        this.uniqueMsg = msg;
        this.cnt = cnt;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.cnt; i++) {
            System.out.println(this.uniqueMsg);
        }
    }
}
