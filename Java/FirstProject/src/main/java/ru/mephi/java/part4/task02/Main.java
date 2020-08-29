package ru.mephi.java.part4.task02;

public class Main {
    public static void main(String[] args) {
        // Point check
        Point p1 = new Point(3, 2);
        System.out.println("I've just created " + p1);

        Point p2 = new Point(3,2);
        System.out.println(p2.equals(p1));
        System.out.println(p2.hashCode() + "," +  p1.hashCode());

        Point p3 = p1;
        System.out.println(p3.equals(p1));
        System.out.println(p3.hashCode() + "," +  p1.hashCode());

        Point p4 = new Point(7, 9);
        System.out.println(p1.equals(p4));
        System.out.println(p1.hashCode() + "," +  p4.hashCode());

        System.out.println(p1.equals(null));

        System.out.println(p1.equals(new Point(3, 2)));
        System.out.println();


        // Labeled point check
        LabeledPoint lp1 = new LabeledPoint("A",3, 2);
        System.out.println("I've just created " + lp1);

        LabeledPoint lp2 = new LabeledPoint("A",3,2);
        System.out.println(lp2.equals(lp1));
        System.out.println(lp2.hashCode() + "," +  lp1.hashCode());

        LabeledPoint lp3 = lp1;
        System.out.println(lp3.equals(lp1));
        System.out.println(lp3.hashCode() + "," +  lp1.hashCode());

        LabeledPoint lp4 = new LabeledPoint("C",7, 9);
        System.out.println(lp1.equals(lp4));
        System.out.println(lp1.hashCode() + "," +  lp4.hashCode());

        System.out.println(lp1.equals(null));
        System.out.println(lp1.equals(new LabeledPoint("A",3, 2)));
    }
}
