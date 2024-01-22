package main;

public class Hedgehog {
    private String name;
    private int age;
    

    public Hedgehog() {
        this.name = "Pikseli";
        this.age = 5;

    }

    public Hedgehog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void speak(String text) {
        System.out.println(name + ": " + text);
    }

    public void run(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(name + " juoksee kovaa vauhtia!");
        }
    }

    public void askInput() {
        System.out.println("Olen " + name + " ja ikäni on " + age + " vuotta, mutta antaisitko silti syötteen?");
    }
}

