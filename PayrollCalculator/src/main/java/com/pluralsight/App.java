package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("data/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine(); //ignore header line

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.trim().split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);
                Employee employee = new Employee(id,name,hoursWorked, payRate);
                System.out.println(employee);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check that files exists at the path needed.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file.");
            throw new RuntimeException(e);
        }
    }
}



