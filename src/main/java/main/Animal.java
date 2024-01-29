package main;

public class Animal {
    private String species;
    private String name;
    private int age;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void run() {
        System.out.println(name + " juoksee kovaa vauhtia!");
    }

    public void printSpecs() {
        System.out.println(species + ": " + name + ", " + age + " vuotta");
    }

}
