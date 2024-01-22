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
        Hedgehog sl = new Hedgehog();
        
        while (true) {
            System.out.println("1) Pistä siili puhumaan, 2) Luo uusi siili, 3) Juoksuta siiliä, 0) Lopeta ohjelma");
            int i = sc.nextInt();

            switch(i) {
                case 1:
                    sc.nextLine();
                    System.out.println("Mitä siili sanoo:");
                    String input = sc.nextLine();

                    if (input.isEmpty()) {
                        sl.askInput();
                    } else {
                        sl.speak(input);
                    }
                    break;
                case 2:
                    System.out.println("Anna siilin nimi:");
                    String name = sc.next();
                    System.out.println("Anna siilin ikä");
                    int age = sc.nextInt();
                    sl = new Hedgehog(name, age);
                    break;
                case 3:
                    System.out.println("Kuinka monta kierrosta?");
                    int kierrosmaara = sc.nextInt();
                    sl.run(kierrosmaara);
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Syöte oli väärä");
                    break;

                }
            }

        }
    }
