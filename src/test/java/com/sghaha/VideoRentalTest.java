package com.sghaha;

import static org.assertj.core.api.Assertions.*;

import com.sghaha.movie.Childrens;
import com.sghaha.movie.Movie;
import com.sghaha.movie.NewRelease;
import com.sghaha.movie.Regular;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VideoRentalTest {

    public static final String NAME = "Kim";
    public static final String TITLE = "Book";
    Customer c;

    @BeforeEach
    void setUp() {
        c = new Customer(NAME);
    }

    private Rental getRental(int priceCode, int daysRented) {
        return new Rental(getMovie(TITLE, priceCode), daysRented);
    }

    private Movie getMovie(String title, int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                return new Regular(title);
            case Movie.NEW_RELEASE:
                return new NewRelease(title);
            case Movie.CHILDRENS:
                return new Childrens(title);
            default:
                return null;
        }
    }

    private String makeStatement1Item(double charge, int point) {
        return "Rental Record for "
            + NAME + "\n"
            + "\t" + TITLE + "\t" + charge + "\n"
            + "Amount owed is " + charge + "\n"
            + "You earned " + point + " frequent renter points";
    }

    @Test
    @DisplayName("레귤러 동작 테스트")
    void t1() {
        c.addRental(getRental(Movie.REGULAR, 1));
        assertThat(c.statement()).isEqualTo(makeStatement1Item(2.0, 1));
    }

    @Test
    @DisplayName("레귤러 1~100일동작 테스트")
    void t1_6() {
        for (int i = 1; i <= 100; i++) {
            setUp();
            c.addRental(getRental(Movie.REGULAR, i));
            assertThat(c.statement())
                .isEqualTo(makeStatement1Item(calChargeForRegular(i), 1));
        }
    }

    private double calChargeForRegular(int daysRented) {
        if (daysRented <= 2) {
            return 2.0;
        } else {
            return (daysRented - 2) * 1.5 + 2.0;
        }
    }

    @Test
    @DisplayName("신작 동작 테스트")
    void t2() {
        c.addRental(getRental(Movie.NEW_RELEASE, 1));
        assertThat(c.statement()).isEqualTo(makeStatement1Item(3.0, 1));
    }

    @Test
    @DisplayName("신작 1일~100일 동작 테스트")
    void t2_1() {
        for (int i = 1; i <= 100; i++) {
            setUp();
            c.addRental(getRental(Movie.NEW_RELEASE, i));
            assertThat(c.statement())
                .isEqualTo(makeStatement1Item(calChargeForNewRelease(i), calPointForNewRelease(i)));
        }
    }

    private double calChargeForNewRelease(int daysRented) {
        return daysRented * 3.0;
    }

    private int calPointForNewRelease(int daysRented) {
        if (daysRented < 2) {
            return 1;
        }
        return 2;
    }

    @Test
    @DisplayName("어린이 동작 테스트")
    void t3() {
        c.addRental(getRental(Movie.CHILDRENS, 1));
        assertThat(c.statement()).isEqualTo(makeStatement1Item(1.5, 1));
    }

    @Test
    @DisplayName("어린이 1~100일 동작 테스트")
    void t3_1() {
        for (int i = 1; i <= 100; i++) {
            setUp();
            c.addRental(getRental(Movie.CHILDRENS, i));
            assertThat(c.statement())
                .isEqualTo(makeStatement1Item(calChargeForChildren(i), 1));
        }
    }

    private double calChargeForChildren(int daysRented) {
        if (daysRented <= 3) {
            return 1.5;
        }
        return (daysRented - 3) * 1.5 + 1.5;
    }

    private int calPointForChildren(int daysRented) {
        if (daysRented < 2) {
            return 1;
        }
        return 2;
    }

}