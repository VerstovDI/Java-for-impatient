package ru.mephi.java.part2.task06;


public class Task06 {
    public static void main(String[] args) {
        ModPoint p = new ModPoint(3,4).translate(1,3).scale(0.5);
        System.out.format("(%s, %s)%n", p.getX(), p.getY());
    }
}
