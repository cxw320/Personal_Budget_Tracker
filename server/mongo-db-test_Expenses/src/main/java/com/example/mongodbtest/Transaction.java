package com.example.mongodbtest;

import org.springframework.data.annotation.Id;

public class Transaction {

    @Id

    private String id;
    private String description;
    private int date;
    private Boolean expense_flag;
    private String category;
    private Double amount;

    public Transaction(String description, int date, Boolean expense_flag, String category, Double amount){

        this.description = description;
        this.date = date;
        this.expense_flag = expense_flag;
        this.category = category;
        this.amount = amount;
    }

    public String getId(){
        return id;
    }

    public int getDate(){
        return date;
    }

    public Boolean getExpense_Flag(){
        return expense_flag;
    }

    public String getDescription(){return description;}

    public String getCategory(){return category;}

    public double getAmount(){return amount;}

}
