package ru.mephi.java.part4.task04;

import ru.mephi.java.part4.task02.Point;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Shape sh = new Shape(Point p); // - так нельзя!
        Shape shape1 = new Circle(new Point(1, 1),2);
        Shape shape2 = new Line(new Point(2, 2), new Point(3, 3));
        Shape shape3 = new Rectangle(new Point(1, 3), 2, 3);
        Shape[] shapes = new Shape[3];
        shapes[0] = shape1;
        shapes[1] = shape2;
        shapes[2] = shape3;
        for (Shape s : shapes) {
            System.out.println(s.getCenter());
        }

        Circle c1 = new Circle(new Point(3 ,3), 2);
        Circle c2 = c1.clone();
        System.out.println(c1.equals(c2));

        Line l1 = new Line(new Point(1 ,1), new Point(9 ,9));
        Line l2 = l1.clone();
        System.out.println(l1.equals(l2));

        Rectangle r1 = new Rectangle(new Point(5 ,5), 3, 4);
        Rectangle r2 = r1.clone();
        System.out.println(r1.equals(r2));
    }
}
