package com.movierental;

import java.util.LinkedHashSet;

public class BillableItems extends LinkedHashSet<BillableItem> {
    public double totalAmount() {
        return this.stream().mapToDouble(BillableItem::getAmount).sum();
    }

    public int totalPoints() {
        return this.stream().mapToInt(BillableItem::getPoints).sum();
    }
}
