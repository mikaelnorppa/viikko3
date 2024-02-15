package main;

public class Ship extends Vehicle { 
    public Ship(String manufacturer, String model, int maxSpeed) {
        super("laiva", manufacturer, model, maxSpeed);
        setEngine(new Engine("Wärtsilä Super", 1000));
    }   
}