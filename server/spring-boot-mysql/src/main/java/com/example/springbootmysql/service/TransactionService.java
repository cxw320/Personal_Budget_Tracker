package com.example.springbootmysql.service;

import com.example.springbootmysql.entity.MonthSummary;
import com.example.springbootmysql.entity.Transaction;
import com.example.springbootmysql.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionService {

    @Autowired
    TransactionRepository transRepo;

    public List<Transaction> findAll() {
        return transRepo.findAll();
    }

    public List<MonthSummary> sumByMonth() {
        return transRepo.sumByMonth();
    }


}
