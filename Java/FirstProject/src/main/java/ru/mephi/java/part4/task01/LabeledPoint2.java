package ru.mephi.java.part4.task01;

public class LabeledPoint2 extends Point2 {
    private final String label;

    public LabeledPoint2(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public LabeledPoint2(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String info() {
        return "Labeled " + super.info();
    }
}
