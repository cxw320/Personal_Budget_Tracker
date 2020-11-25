package com.example.springbootmysql.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Column(name ="ID")
    @Id
    private Long id;

    @Column(name="description")
    @Basic
    private String description;

    @Column(name="date")
    @Basic
    private LocalDate date;

    @Column(name="month")
    @Basic
    private LocalDate month;

    @Column(name="year")
    @Basic
    private LocalDate year;

    @Column(name="category")
    @Basic
    private String category;

    @Column(name="amount")
    @Basic
    private double amount;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getMonth() {
        return month;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }


}
