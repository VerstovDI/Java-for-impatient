package ru.mephi.java.part2.task09;

public class Car {
    private final double xStart;               // Начальная позиция автомобиля на оси x
    private double xCoordinate;                // Текущая координата автомобиля на оси x
    private double mileage = 0;                // Пробег автомобиля (сколько всего автомобиль проехал, тронувшись с xStart)
    private final double fuelCapacity = 80;    // Максимальная вместимость бензобака автомобиля (0 <= liters <= fuelCapacity)
    private double fuel;                       // Текущий запас топлива в бензобаке автомобиля (0 <= liters <= fuelCapacity)
    private final double consumption;          // Расход топлива (liters/100km.)

    //Constructors
    public Car() {
        this.xStart = 0;
        this.xCoordinate = 0;
        this.fuel = this.fuelCapacity;
        this.consumption = 8;
    }

    public Car(double fuel) {
        this.xStart = 0;
        this.xCoordinate = 0;
        if (fuel < 0) {
            throw new IllegalArgumentException("Amount of fuel should be positive!");
        }
        else if (fuel > fuelCapacity) {
            System.out.println("Amount of fuel more than possible one (80 l.). The default was set (80 l.)");
            this.fuel = fuelCapacity;
        } else {
            this.fuel = fuel;
        }
        this.consumption = 8;
    }

    public Car(double fuel, double consumption) {
        this.xStart = 0;
        this.xCoordinate = 0;
        if (fuel < 0) {
            throw new IllegalArgumentException("Amount of fuel must be positive!");
        } else if (fuel > fuelCapacity) {
            System.out.println("The amount of fuel more than possible one (80 l.). The default was set (80 l.)");
            this.fuel = fuelCapacity;
        } else {
            this.fuel = fuel;
        }
        if (consumption < 0) {
            throw new IllegalArgumentException("Consumption parameter must be positive!");
        } else if (consumption > fuel * 10000) {
            throw new IllegalArgumentException("Car will never move with this consumption!");
        } else {
            this.consumption = consumption;
        }
    }

    public Car(double fuel, double consumption, double xStart) {
        this.xStart = xStart;
        this.xCoordinate = this.xStart;
        if (fuel < 0) {
            throw new IllegalArgumentException("Amount of fuel must be positive!");
        } else if (fuel > fuelCapacity) {
            System.out.println("The amount of fuel more than possible one (80 l.). The default was set (80 l.)");
            this.fuel = fuelCapacity;
        } else {
            this.fuel = fuel;
        }
        if (consumption < 0) {
            throw new IllegalArgumentException("Consumption parameter must be positive!");
        } else if (consumption > fuel * 10000) {
            throw new IllegalArgumentException("Car will never move with this consumption!");
        } else {
            this.consumption = consumption;
        }
    }

    // Getters
    public double fuelResidue() {
        return this.fuel;
    }

    public double currPosition() {
        return this.xCoordinate;
    }

    public double startPosition() {
        return this.xStart;
    }

    public double getConsumption() {
        return this.consumption;
    }

    public double distance() {
        return this.mileage;
    }

    // Other methods
    public void move(double moveDist, double direction) {        // moveDist in km.
        if ((direction != 1) && (direction != -1)) {             // 1 if to x, -1 if against x
            throw new IllegalArgumentException("Incorrect format of \"direction\" parameter");
        }
        double fuelToMove = moveDist * (this.consumption / 100);
        if (this.fuel >= fuelToMove) {
            this.xCoordinate += direction * moveDist;
            this.mileage += moveDist;
            this.fuel -= fuelToMove;
        } else {
            this.xCoordinate += direction * fuel / (this.consumption / 100);
            this.mileage += fuel / (this.consumption / 100);
            this.fuel = 0;
        }
    }

    public void addFuel(double fuelAmount) {
        if (fuelAmount >= 0) {
            if ( (fuelAmount + this.fuel) >= fuelCapacity ) {
                this.fuel = fuelCapacity;
            } else {
                this.fuel += fuelAmount;
            }
        } else {
            throw new IllegalArgumentException("Incorrect format of \"direction\" parameter");
        }
    }
}
