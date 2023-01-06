package com.sghaha;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VideoRentalTest {

    @Test
    @DisplayName("초기 테스트")
    void name() {
        assertThat(10).isEqualTo(10);
    }

    @Test
    @DisplayName("기본 동작 테스트")
    void t1() {
        Customer c = new Customer("Kim");
        Movie m = new Movie("Book", Movie.REGULAR);
        Rental r = new Rental(m, 1);

        c.addRental(r);
        System.out.println(c.statement());

        assertThat(c.statement()).isEqualTo(
            "Rental Record for Kim\n"
                + "\tBook\t2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points"
        );

    }
}