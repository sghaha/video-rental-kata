package com.sghaha.movie;

public class Childrens extends Movie{

    public Childrens(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    public double calculateCharge(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3)
            charge += (daysRented - 3) * 1.5;
        return charge;
    }

    @Override
    public int calculatePoint(int daysRented) {
        return 1;
    }


}
