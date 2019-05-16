package com.movierental;

import com.movierental.formatters.Formatter;
import com.movierental.formatters.HtmlFormatter;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

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
        return this.generateStatement(new Formatter());
    }

    public String htmlStatement() {
        return this.generateStatement(new HtmlFormatter());
    }

    private String generateStatement(Formatter formatter) {
        BillableItems billableItems = new BillableItems();
        for (Rental each : rentals) {
            billableItems.add(new BillableItem(each.getMovie().getTitle(), each.amount(), each.renterPoints()));
        }

        return new StatementGenerator(formatter).forCustomer(getName()).withItems(billableItems).generate();
    }
}