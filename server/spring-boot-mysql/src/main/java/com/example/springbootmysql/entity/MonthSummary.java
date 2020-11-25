package com.example.springbootmysql.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class MonthSummary {

    @Id
    private LocalDate month;
    @Column(name="amount")
    @Basic
    private double amount;

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }
}
