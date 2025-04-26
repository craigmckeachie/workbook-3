package com.pawsitive;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visit {
    LocalDateTime visitedOn;
    String notes;
    int length;
    double amount;

    public Visit(LocalDateTime visitedOn, String notes, int length, double amount) {
        this.visitedOn = visitedOn;
        this.notes = notes;
        this.length = length;
        this.amount = amount;
    }

    public LocalDateTime getVisitedOn() {
        return visitedOn;
    }

    public void setVisitedOn(LocalDateTime visitedOn) {
        this.visitedOn = visitedOn;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String display() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MMM dd, yyyy hh:mm a");
        StringBuilder builder = new StringBuilder();
        builder.append(visitedOn.format(format)).append("\t").append(length).append(" minutes").append("\n")
                .append(notes).append("\n")
                .append("__________________________________________________________________________");
        return builder.toString();

    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatForFile = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");

        String visitAsString = String.format("%s|%s|%d|%.2f", visitedOn.format(dateFormatForFile), notes,length, amount);
        return visitAsString;
    }
}

