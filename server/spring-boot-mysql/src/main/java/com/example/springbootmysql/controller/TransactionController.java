package com.example.springbootmysql.controller;

import com.example.springbootmysql.entity.MonthSummary;
import com.example.springbootmysql.entity.Transaction;
import com.example.springbootmysql.repository.TransactionRepository;
import com.example.springbootmysql.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transService;

    @Autowired
    TransactionRepository transRepo;

    public TransactionController(TransactionService transService, TransactionRepository transRepo) {
        this.transService = transService;
        this.transRepo = transRepo;
    }

    @RequestMapping("/all")
    public List<Transaction> getAll() {
        List<Transaction> transactions = transService.findAll();
        return transactions;
    }

    @RequestMapping("/MonthSum")
    public List<MonthSummary> sumByMonth() {
        List<MonthSummary> monthSummary = transService.sumByMonth();
        return monthSummary;
    }


}
