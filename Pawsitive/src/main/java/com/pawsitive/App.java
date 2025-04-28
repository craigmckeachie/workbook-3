package com.pawsitive;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            showMainMenu();
            int selectedMenuOption = scanner.nextInt();
            scanner.nextLine();

            switch (selectedMenuOption) {
                case 1:
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
                    running = false;
                    break;
                default:
                    System.out.println("Invalid menu option. Try again.");
            }
        }
    }

    public static void viewVisits() {
        System.out.println("\nVisits");
        System.out.println("---------------------");
        System.out.println();

        ArrayList<Visit> visits= readVisitsFromFile();
        displayVisits(visits);

        promptReturnToMenu();
    }

    private static void displayVisits(ArrayList<Visit> visits) {
        for (Visit visit: visits){
            System.out.println(visit.display());
        }
    }

    private static ArrayList<Visit> readVisitsFromFile() {
        ArrayList<Visit> visits = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader("data/visits.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");

                LocalDateTime visitedOn = LocalDateTime.parse(tokens[0] + "T" + tokens[1]);
                String notes = tokens[2];
                int length = Integer.parseInt(tokens[3]);
                double amount = Double.parseDouble(tokens[4]);
                Visit visit = new Visit(visitedOn, notes, length, amount);
                visits.add(visit);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (
                NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        }
        return visits;
    }

    public static void addVisit() {
        System.out.println("\nAdd Visit");
        System.out.println("---------------------");

        System.out.println("\nEnter notes: ");
        String notes = scanner.nextLine();

        System.out.print("\nEnter length of visit in minutes: ");
        int length = scanner.nextInt();

        System.out.print("\nEnter charges: ");
        double amount = scanner.nextDouble();

        Visit visit = new Visit(LocalDateTime.now(), notes, length, amount);
        saveVisit(visit);
        promptReturnToMenu();
    }

    public static void saveVisit(Visit visit) {
        try {
            FileWriter fileWriter = new FileWriter("data/visits.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n");
            bufferedWriter.write(visit.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred saving the visit. Please try again.");
            e.getStackTrace();
        }
    }

    public static void runReports() {
        System.out.println("\nRun Reports");
        System.out.println("---------------------");
        System.out.println();

        boolean running = true;
        while (running) {
            showReportsMenu();
            int selectedMenuOption = scanner.nextInt();
            scanner.nextLine();

            switch (selectedMenuOption) {
                case 1:
                    //call a method to render a screen
                    runVisitsOverLastWeekReport();
                    break;
                case 2:
                    runVisitsOver1Hour();
                    break;
                case 3:
                    //todo
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid report menu option. Try again.");
            }
        }

    }

    public static void runVisitsOverLastWeekReport() {
        System.out.println("\nVisits over Last Week");
        System.out.println("---------------------");

        ArrayList<Visit> visits= readVisitsFromFile();
        ArrayList<Visit> visitsOverLastWeek = filterToVisitsOverLastWeek(visits);
        displayVisits(visitsOverLastWeek);

        promptReturnToReportMenu();
    }

    private static ArrayList<Visit> filterToVisitsOverLastWeek(ArrayList<Visit> visits) {
        LocalDateTime startDate = LocalDateTime.now().minusWeeks(1);
        LocalDateTime endDate = LocalDateTime.now();
        ArrayList<Visit> visitsOverLastWeek = new ArrayList<>();
        for (Visit visit: visits){
            if (visit.visitedOn.isAfter(startDate) && visit.visitedOn.isBefore(endDate)){
                visitsOverLastWeek.add(visit);
            }
        }
        return visitsOverLastWeek;
    }

    public static void runVisitsOver1Hour() {
        System.out.println("\nVisits over 1 hour");
        System.out.println("---------------------");
        System.out.println();
        System.out.println();
        promptReturnToReportMenu();
    }

    private static void promptReturnToReportMenu() {
        System.out.println("\nPress Enter to return to the report menu...");
        scanner.nextLine();
    }

    private static void promptReturnToMenu() {
        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    public static void showReportsMenu() {
        System.out.println("Reports");
        System.out.println("---------------------");
        System.out.println("\nWhat report do you wan to run?");
        System.out.println(" 1- Visits over Last Week");
        System.out.println(" 2- Visits over 1 hour");
        System.out.println(" 3- Visits on a day");
        System.out.println(" 4- Return to the main menu");
        System.out.print("Enter command: ");
    }

    public static void showMainMenu() {
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


