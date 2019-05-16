package com.movierental.formatters;

import com.movierental.BillableItem;

public class HtmlFormatter extends Formatter {
    @Override
    public String formatHeader(String customerName) {
        return "<h1>Rental Record for <b>" + customerName + "</b></h1><br/>";
    }

    @Override
    public String formatLineItem(BillableItem item) {
        return "\t" + item.getTitle() + "\t" + item.getAmount() + "<br/>";
    }

    @Override
    public String formatTotalAmount(double totalAmount) {
        return "Amount owed is <b>" + totalAmount + "</b><br/>";
    }

    @Override
    public String formatRenterPoints(int totalPoints) {
        return "You earned <b>" + totalPoints + "</b> frequent renter points";
    }
}
