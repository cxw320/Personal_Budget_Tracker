package com.example.mongodbtest.summaryClasses;


public class MonthCategorySummary {

    private String month;
    private double foodAmount;
    private double rentAmount;


    public MonthCategorySummary(String month, double foodAmount, double rentAmount){
        this.month = month;
        this.foodAmount = foodAmount;
        this.rentAmount = rentAmount;

    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setFoodAmount(double amount) {
        this.foodAmount = amount;
    }
    public void setRentAmount(double amount) {
        this.rentAmount = amount;
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
