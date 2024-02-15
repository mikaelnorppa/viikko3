package main;

public class Car extends Vehicle {
    public Car(String manufacturer, String model, int maxSpeed) {
        super("auto", manufacturer, model, maxSpeed);
        setEngine(new Engine("V8", 300));
    }
}
