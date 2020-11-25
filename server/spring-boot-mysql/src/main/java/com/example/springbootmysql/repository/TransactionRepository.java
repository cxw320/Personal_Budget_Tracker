package com.example.springbootmysql.repository;

import com.example.springbootmysql.entity.MonthSummary;
import com.example.springbootmysql.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT month, sum(amount) FROM transaction group by month",
            nativeQuery = true)
    public List<MonthSummary> sumByMonth();

    //next step to add month year field in sql table
    // try the sum groupby query in jsql
    // try to set up a transaction service class that
       // generates the month and year property for persisting to the table
    // native query annotation that can be regular sql, date between

}
