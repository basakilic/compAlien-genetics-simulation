package folder;

import java.util.Scanner;


public class compAlienGeneticsSimulation {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of compAlien population: ");
        int population = input.nextInt();
        System.out.println("Simulating compAlien species… ");
        String[][] codes = new String[population][];
        for (int i = 0; i < population; i++) {
            codes[i] = geneticCodes();
            System.out.print("ID:" + i + ", " + "Health: " + Health(codes[i]) + ", " + Gender(codes[i]));
            System.out.println();
            System.out.println("---------------------------------");
        }
        System.out.println("CompAlien population is generated !");
        System.out.println("---------------------------------");
        menu();
        System.out.print("Enter an option: ");
        int option = input.nextInt();
        options(option, codes);
    }


    public static int Health(String[] geneticCode) {
        int count = 0;
        for (int i = 0; i < geneticCode.length - 2; i++) {
            if ((geneticCode[i].equals("y") &&
                    geneticCode[i + 1].equals("x") &&
                    geneticCode[i + 2].equals("z"))) {
                count++;
            }
        }
        return count;
    }

    
    public static String Gender(String[] geneticCode) {
        if (geneticCode[127].equals("y")) {
            return "Male";
        } else  // "z" or "x"
            return "Female";
    }
//        System.out.print("(" + geneticCode[127] + ")");// for testing genders of aliens are correct or not


    public static String[] geneticCodes() {
        String[] genetic = new String[128];
        for (int i = 0; i < 128; i++) {
            int result = (int) (Math.random() * 3);
            if (result == 0) {
                genetic[i] = "x";
            } else if (result == 1) {
                genetic[i] = "y";
            } else
                genetic[i] = "z";
        }
        return genetic;
    }

    
    public static void menu() {
        System.out.println("Choose an options: ");
        System.out.println("(1)Mate two compAliens ");
        System.out.println("(2)Randomly mate a set of compAliens ");
        System.out.println("(3)Show statistics ");
        System.out.println("(4)Has green eyes");
        System.out.println("(5)Blood color ");
    }


    public static void options(int option, String[][] codes) {
        Scanner input = new Scanner(System.in);
        while (option != 0) {
            if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
                switch (option) {
                    case 1:
                        System.out.print("Enter ID of first compAlien: ");
                        int id1 = input.nextInt();
                        System.out.print("Enter ID of second compAlien: ");
                        int id2 = input.nextInt();
                        System.out.println("Mating two compAliens ...");
                        System.out.println("- - - - - - - - - - - - - - - - ");
                        System.out.println(mateTwoAliens(codes[id1], codes[id2]));
                        System.out.println("---------------------------------");
                        break;

                    case 2:
                        System.out.print("Enter number of compAlien pairs to reproduce: ");
                        int random = input.nextInt();
                        for (int i = 1; i <= random; i++) {
                            int randomfor1 = (int) (Math.random() * random);
                            int randomfor2 = (int) (Math.random() * random);
                            System.out.println("---------------------------------");
                            System.out.println("Simulating Random compAlien Reproduction ");
                            System.out.println("---------------------------------");
                            System.out.println(randomlyMate(codes[randomfor1], codes[randomfor2]));
                            System.out.println("---------------------------------");
                        }
                        break;

                    case 3:
                        System.out.println("Statistics : Sorry i couldnt..");
                        System.out.println("---------------------------------");
                        Statistics();
                        break;

                    case 4:
                        System.out.println("Do you have green eyes ? : ");
                        System.out.println("Choose id to check green eyes for alien: ");
                        int num = input.nextInt();
                        System.out.println(hasGreenEyes(codes[num]));
                        System.out.println("---------------------------------");
                        break;
                        
                    case 5:
                        System.out.println("Enter id to check blood color for alien: ");
                        num = input.nextInt();
                        System.out.println(bloodColor(codes[num]));
                        System.out.println("---------------------------------");
                        break;

                    default:
                }
            } else {
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("Enter a valid option !");
                System.out.println("- - - - - - - - - - - - -");
            }
            menu();
            System.out.println("Enter an option");
            option = input.nextInt();
        }
        System.out.println("You entered 0, you choose to finish. See you :)");
    }


    public static String mateTwoAliens(String[] first, String[] second) {
        if (Gender(first).equals(Gender(second))) {
            return "They can NOT have a baby :( ";
        } else {
            return "They can have a baby :)";
        }
    }

    public static String randomlyMate(String[] first, String[] second) {
        if (Gender(first).equals(Gender(second))) {
            return "They can NOT have a baby :( ";
        } else {
            return "They can have a baby :)";
        }
    }

    public static void Statistics() {
    }

    public static String hasGreenEyes(String[] array) {
        // if the letter int the middle of the genetic code is "z"; this alien has green eyes.
        System.out.println();
        if ((array[63].equals("z"))) {
            return "Green eyes  ";
        } else
            return "Not green eyes !";
    }

    public static String bloodColor(String[] array) {
        if ((array[0].equals("y"))) {
            return "Green blood ! ";
        } else if (array[0].equals("x")) {
            return "Blue blood !";
        } else

            return "Yellow blood !";
    }
}
    
    

