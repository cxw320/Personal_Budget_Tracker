package com.example.mongodbtest;

import org.springframework.data.annotation.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    @Id

    private String id;
    private String description;
    private String date;
    private Boolean expense_flag;
    private String category;
    private Double amount;
    private DateTimeFormatter yearMonthValue;

    public Transaction(String description, String date, Boolean expense_flag, String category, Double amount){

        this.description = description;
        this.date = date;
        this.expense_flag = expense_flag;
        this.category = category;
        this.amount = amount;
        this.yearMonthValue = null;
    }

    public String getId(){
        return id;
    }

    public String getDate(){
        return date;
    }

    public void updateYearMonthValue(DateTimeFormatter yearMonthValue){
        this.yearMonthValue = yearMonthValue;
    }

    public Boolean getExpense_Flag(){
        return expense_flag;
    }

    public String getDescription(){return description;}

    public String getCategory(){return category;}

    public double getAmount(){return amount;}

}
