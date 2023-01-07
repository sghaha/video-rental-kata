package com.sghaha;

import com.sghaha.movie.Movie;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        result += createListStatement();
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalPoint() + " frequent renter points";
        return result;
    }

    private String createListStatement() {
        String result = "";
        for (Rental each: rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getChargeFor() + "\n";
        }
        return result;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental each: rentals) {
            double thisAmount = 0;
            thisAmount = each.getChargeFor();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    private int getTotalPoint() {
        int result = 0;
        for (Rental each: rentals) {
            result += each.getPointFor();
        }
        return result;
    }

}