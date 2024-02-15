package main;

public class Plane extends Vehicle {
    public Plane(String manufacturer, String model, int maxSpeed) {
        super("lentokone", manufacturer, model, maxSpeed);
        setEngine(new Engine("Suihkumoottori", 500));
    }
}