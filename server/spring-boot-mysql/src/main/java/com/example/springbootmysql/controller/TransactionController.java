package com.example.springbootmysql.controller;

import com.example.springbootmysql.entity.Transaction;
import com.example.springbootmysql.repository.TransactionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @RequestMapping("/all")
    public List<Transaction> getAll() {
        List<Transaction> transactions = this.transactionRepository.findAll();
        return transactions;

    }


}
