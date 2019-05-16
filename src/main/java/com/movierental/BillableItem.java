package com.movierental;

public class BillableItem {
    private final String title;
    private final double amount;
    private final int points;

    public BillableItem(String title, double amount, int points) {
        this.title = title;
        this.amount = amount;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public int getPoints() {
        return points;
    }
}
