package com.movierental;

import com.movierental.formatters.Formatter;

public class StatementGenerator {
    private String customerName;
    private BillableItems items;

    private Formatter formatter;

    public StatementGenerator(Formatter formatter) {
        this.formatter = formatter;
    }

    public StatementGenerator forCustomer(String name) {
        this.customerName = name;
        this.items = new BillableItems();
        return this;
    }

    public StatementGenerator withItems(BillableItems billableItems) {
        this.items = billableItems;
        return this;
    }

    public String generate() {
        StringBuilder result = new StringBuilder(formatter.formatHeader(customerName));

        for (BillableItem item : items) {
            result.append(formatter.formatLineItem(item));
        }

        result.append(formatter.formatTotalAmount(items.totalAmount()));
        result.append(formatter.formatRenterPoints(items.totalPoints()));

        return result.toString();
    }
}
