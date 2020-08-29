package ru.mephi.java.part2.task05;
import static java.lang.System.out;

public class Task05 {

    public static void main(String[] args) {
        Point p = new Point(3,4).translate(1,3).scale(0.5);
        out.format("(%s, %s)%n", p.getX(), p.getY());
    }
}
