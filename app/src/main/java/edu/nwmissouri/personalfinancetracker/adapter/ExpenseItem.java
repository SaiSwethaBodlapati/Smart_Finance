package edu.nwmissouri.personalfinancetracker.adapter;

public class ExpenseItem {
    private String category;
    private String amount;
    private String date;

    public ExpenseItem(String category, String amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
