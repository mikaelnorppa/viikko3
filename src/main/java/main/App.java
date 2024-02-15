package main;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Hello world!!
 *
 */
public class App 

{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();


        boolean exit = false;
        while (!exit) {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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

