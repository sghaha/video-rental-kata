package com.sghaha.movie;

public class NewRelease extends Movie {

    public NewRelease(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int calculatePoint(int daysRented) {
        if (daysRented < 2) {
            return 1;
        }
        return 2;
    }
}
