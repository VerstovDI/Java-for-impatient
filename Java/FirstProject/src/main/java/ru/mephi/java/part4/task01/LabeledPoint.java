package ru.mephi.java.part4.task01;

public class LabeledPoint extends Point {
    private final String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public LabeledPoint(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
