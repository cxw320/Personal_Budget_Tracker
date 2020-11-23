package com.example.mongodbtest;

public class MonthlySummary {

    String month;
    double foodAmount;
    double rentAmount;

    public MonthlySummary(String month, double foodAmount, double rentAmount){
        this.month = month;
        this.foodAmount = foodAmount;
        this.rentAmount = rentAmount;
    }

}
