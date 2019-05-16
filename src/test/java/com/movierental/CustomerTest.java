package com.movierental;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void shouldApplyNormalChargesForCustomerWhoHasRegularMovieRentalForLessThan3Days() {
        Customer customer = new Customer("Mr. Koo");
        Movie badla = new Movie("Badla", Movie.REGULAR);
        customer.addRental(new Rental(badla, 2));

        assertThat(customer.statement(), is("Rental Record for Mr. Koo\n\tBadla\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points"));
        assertThat(customer.htmlStatement(), is("<h1>Rental Record for <b>Mr. Koo</b></h1><br/>\tBadla\t2.0<br/>Amount owed is <b>2.0</b><br/>You earned <b>1</b> frequent renter points"));
    }

    @Test
    public void shouldApplyExtraChargesForCustomerWhoHasRegularMovieRentalForMoreThan2Days() {
        Customer customer = new Customer("Mr. Koo");
        Movie badla = new Movie("Badla", Movie.REGULAR);
        customer.addRental(new Rental(badla, 3));

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\n\tBadla\t3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points"));
    }

    @Test
    public void shouldApplyNormalChargesForCustomerWhoHasNewReleaseMovieRentalFor1Day() {
        Customer customer = new Customer("Mr. Koo");
        Movie avengers = new Movie("Avengers", Movie.NEW_RELEASE);
        customer.addRental(new Rental(avengers, 1));

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\n\tAvengers\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"));
    }

    @Test
    public void shouldGiveAnExtraRenterPointForCustomerWhoHasNewReleaseMovieRentalForMoreThan1Day() {
        Customer customer = new Customer("Mr. Koo");
        Movie avengers = new Movie("Avengers", Movie.NEW_RELEASE);
        customer.addRental(new Rental(avengers, 3));

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\n\tAvengers\t9.0\nAmount owed is 9.0\nYou earned 2 frequent renter points"));
    }

    @Test
    public void shouldApplyNormalChargesForCustomerWhoHasChildrenMovieRentalForLessThan4Days() {
        Customer customer = new Customer("Mr. Koo");
        Movie it = new Movie("It", Movie.CHILDRENS);
        customer.addRental(new Rental(it, 3));

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\n\tIt\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"));
    }

    @Test
    public void shouldApplyExtraChargesForCustomerWhoHasChildrenMovieRentalForMoreThan3Days() {
        Customer customer = new Customer("Mr. Koo");
        Movie it = new Movie("It", Movie.CHILDRENS);
        customer.addRental(new Rental(it, 4));

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\n\tIt\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"));
    }

    @Test
    public void shouldGenerateProperStatementForCustomerWhoDoesNotHaveAnyRentals() {
        Customer customer = new Customer("Mr. Koo");

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\nAmount owed is 0.0\nYou earned 0 frequent renter points"));
    }

    @Test
    public void shouldGenerateStatementConsideringMultipleRentals() {
        Customer customer = new Customer("Mr. Koo");
        Movie badla = new Movie("Badla", Movie.REGULAR);
        Movie avengers = new Movie("Avengers - End Game", Movie.NEW_RELEASE);
        Movie it = new Movie("It", Movie.CHILDRENS);
        customer.addRental(new Rental(badla, 4));
        customer.addRental(new Rental(avengers, 4));
        customer.addRental(new Rental(it, 2));

        String statement = customer.statement();

        assertThat(statement, is("Rental Record for Mr. Koo\n\tBadla\t5.0\n\tAvengers - End Game\t12.0\n\tIt\t1.5\nAmount owed is 18.5\nYou earned 4 frequent renter points"));
    }
}