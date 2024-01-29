package main;
import java.util.ArrayList;

public class Zoo {
    private String name;
    private ArrayList<Animal> animals = new ArrayList<>();
    

    public Zoo(String name) {
        this.name = name;
    }

    public void addAnimal(String species, String name, int age) {
        Animal nAnimal = new Animal(species, name, age);
        animals.add(nAnimal);
    }

    public void listAnimals() {
        System.out.println(name + " pitää sisällään seuraavat eläimet:");
        for (Animal animal : animals) {
            animal.printSpecs();
        }
    }

    public void runAnimals(int rounds) {
        for (Animal animal : animals) {
            for (int round = 0; round < rounds; round++) {
                animal.run();
            }
        }
    }
}

