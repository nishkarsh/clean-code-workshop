package com.movierental.formatters;

import com.movierental.BillableItem;

public class Formatter {
    public String formatHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

    public String formatLineItem(BillableItem item) {
        return "\t" + item.getTitle() + "\t" + item.getAmount() + "\n";
    }

    public String formatTotalAmount(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";
    }

    public String formatRenterPoints(int totalPoints) {
        return "You earned " + totalPoints + " frequent renter points";
    }
}
