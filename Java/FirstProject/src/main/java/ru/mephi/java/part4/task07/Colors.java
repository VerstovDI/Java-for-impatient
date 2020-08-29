package ru.mephi.java.part4.task07;

public enum Colors {
    BLACK(0,0,0),
    RED(255,0,0),
    BLUE(0,0,255),
    GREEN(0,255,0),
    CYAN(0,255,255),
    MAGENTA(255,0,255),
    YELLOW(255,255,0),
    WHITE(255,255,255);

    private int red;
    private int green;
    private int blue;

    Colors (int red, int green, int blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
