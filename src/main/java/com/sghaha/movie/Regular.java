package com.sghaha.movie;

public class Regular extends Movie {

    public Regular(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    public double calculateCharge(int daysRented) {
        double charge = 2;
        if (daysRented > 2) {
            charge += (daysRented - 2) * 1.5;
        }
        return charge;
    }

    @Override
    public int calculatePoint(int daysRented) {
        return 1;
    }
}
