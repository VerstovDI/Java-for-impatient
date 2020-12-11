package ru.mephi.java.part7.task10;

public class Neighbour {
    private String cityName;
    private int distance;

    public Neighbour(String cityName, int distance) {
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
        return "Neighbour{" +
                "cityName='" + cityName + '\'' +
                ", distance=" + distance +
                '}';
    }
}
