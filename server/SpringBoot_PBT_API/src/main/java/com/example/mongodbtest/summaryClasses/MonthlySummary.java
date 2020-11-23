package com.example.mongodbtest.summaryClasses;

public class MonthlySummary {

    private String month;
    private double amount;


    public MonthlySummary(String month, double amount){
        this.month = month;
        this.amount = amount;

    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }

}
