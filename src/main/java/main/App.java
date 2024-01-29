package main;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Anna eläintarhalle nimi:");
        String zooName = sc.nextLine();
        Zoo zoo = new Zoo(zooName);


        boolean exit = false;
        while (!exit) {
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
            int i = sc.nextInt();
            sc.nextLine();

            switch(i) {
                case 1:
                    System.out.println("Mikä laji?");
                    String species = sc.nextLine();
                    System.out.println("Anna eläimen nimi:");
                    String name = sc.nextLine();
                    System.out.println("Anna eläimen ikä:");
                    int age = sc.nextInt();
                    zoo.addAnimal(species, name, age);
                    break;
                case 2:
                    zoo.listAnimals();
                    break;
                case 3:
                    System.out.println("Kuinka monta kierrosta?");
                    int rounds = sc.nextInt();
                    zoo.runAnimals(rounds);
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Syöte oli väärä");
                    break;

                }
            }
        }

}

