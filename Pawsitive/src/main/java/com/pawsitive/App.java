package com.pawsitive;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean running = true;
        while (running){
            showMainMenu();
            int selectedMenuOption = scanner.nextInt();
            scanner.nextLine();

            switch (selectedMenuOption){
                case 1:
                    //call a method to render a screen
                    viewVisits();
                    break;
                case 2:
                    addVisit();
                    break;
                case 3:
                    runReports();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    running =false;
                    break;
                default:
                    System.out.println("Invalid menu option. Try again.");
            }
        }
    }

    public static void viewVisits(){
        System.out.println("\nVisits");
        System.out.println("---------------------");
        System.out.println();
        System.out.println();

        promptReturnToMenu();
    }

    public static void addVisit(){
        System.out.println("\nAdd Visit");
        System.out.println("---------------------");
        System.out.println();
        System.out.println();
        promptReturnToMenu();
    }

    public static void runReports(){
        System.out.println("\nRun Reports");
        System.out.println("---------------------");
        System.out.println();
        System.out.println();
        promptReturnToMenu();
    }


    private static void promptReturnToMenu() {
        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    public static void showMainMenu(){
        System.out.println("Pawsitive Pets");
        System.out.println("---------------------");
        System.out.println("\nWhat do you want to do?");
        System.out.println(" 1- View Visits");
        System.out.println(" 2- Add Visit");
        System.out.println(" 3- Run Reports");
        System.out.println(" 4- Exit Application");
        System.out.print("Enter command: ");
    }

}
