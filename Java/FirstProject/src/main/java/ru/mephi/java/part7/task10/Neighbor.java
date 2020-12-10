package ru.mephi.java.part7.task10;

public class Neighbor {
    private String cityName = "unknown";
    private int distance = -1;

    public Neighbor() { }

    public Neighbor(String cityName, int distance) {
        this.cityName = cityName;
        this.distance = distance;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "cityName='" + cityName + '\'' +
                ", distance=" + distance +
                '}';
    }
}
