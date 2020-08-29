package ru.mephi.java.part4.task01;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2.5, 3.0);
        LabeledPoint lp1 = new LabeledPoint("Labeled point #1");
        LabeledPoint lp2 = new LabeledPoint("Labeled point #2", 2, 3);
        // Вызывает метод класса, которому принадлежит экземпляр
        System.out.println("Вызов метода getX() на экземлпяре p1 класса Point: " + p1.getX());
        // Вызывается тот же метод, но на классе-наследнике. Методы наследуются. Конструкторы не наследуются!
        p1 = lp2;
        System.out.println("Вызов метода getX() на экземлпяре lp1 класса Point: " + p1.getX());
        // LabeledPoint - родитель для Point, subclass можно присваивать superclass
        // Но после присвоения ссылки на экземпляр LabeledPoint с помощью p2 можно получить доступ только к методам Point!
        Point p2 = lp2;
        // В p2 хранится ссылка на дочерник класс, но вызвать можно только методы родительского класса!
        // Не получится на p2 вызвать метод getLabel
        System.out.println("x = " + p2.getX() + ", y = " + p2.getY());
        System.out.println("x = " + lp2.getX() + ", y = " + lp2.getY());
        System.out.println(lp1.getLabel());

        //---
        Point2 point2 = new Point2(5, 6);
        LabeledPoint2 labeledPoint2 = new LabeledPoint2("Hello!",point2.getX(), point2.getY());
        System.out.println(point2.info());
        System.out.println(labeledPoint2.info());
        point2 = labeledPoint2;
        System.out.println(point2.info());
    }
}
