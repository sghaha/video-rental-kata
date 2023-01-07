package com.sghaha;

import com.sghaha.movie.Movie;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getChargeFor() {
        return movie.calculateCharge(daysRented);
    }

    public int getPointFor() {
        return movie.calculatePoint(daysRented);
    }
}