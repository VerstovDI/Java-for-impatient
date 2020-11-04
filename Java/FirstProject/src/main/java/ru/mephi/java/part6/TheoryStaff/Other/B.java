package ru.mephi.java.part6.TheoryStaff.Other;

public class B extends A<Float> {
    @Override
    void setValue(Float value) {
        super.setValue(value);
    }
    // Сигнатура его bridge-метода -> void setValue(Number value)
    // внутри этот bridge-метод делает каст: this.setValue((Float) value);
}
