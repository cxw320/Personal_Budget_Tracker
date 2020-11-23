package com.example.mongodbtest;

public class MonthlySummary {

    private String month;
    private double foodAmount;
    private double rentAmount;

    public MonthlySummary(String month, double foodAmount, double rentAmount){
        this.month = month;
        this.foodAmount = foodAmount;
        this.rentAmount = rentAmount;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setFoodAmount(double foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getMonth() {
        return month;
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public double getRentAmount() {
        return rentAmount;
    }
}
