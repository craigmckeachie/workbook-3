package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {


    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String todayAsString = today.format(format);
        System.out.println(todayAsString);

    }



}
