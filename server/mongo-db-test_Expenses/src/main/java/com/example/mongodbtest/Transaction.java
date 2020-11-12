package com.example.mongodbtest;

import org.springframework.data.annotation.Id;

public class Transaction {

    @Id
    private String id;
    private String description;
    private String category;
    private double amount;

    public Transaction(String description, String category, double amount){
        this.description = description;
        this.category = category;
        this.amount = amount;
    }

    public String getId(){
        return id;
    }

    public String getDescription(){return description;}

    public String getCategory(){return category;}

    public double getAmount(){return amount;}

}
