package main;

public class Vehicle {
    String type;
    String manufacturer;
    String model;
    int maxSpeed;
    Engine engine;

    public Vehicle(String type, String manufacturer, String model, int maxSpeed) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    public void drive() {
        System.out.println(manufacturer + " " + model + " paahtaa tietä eteenpäin!");
    }

    public void fly() {
        System.out.println(manufacturer + " " + model + " lentää kohteeseen!");
    }

    public void sail() {
        System.out.println(manufacturer + " " + model + " seilaa merten ääriin");
    }

}
