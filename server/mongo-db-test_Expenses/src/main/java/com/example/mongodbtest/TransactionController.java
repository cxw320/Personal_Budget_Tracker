package com.example.mongodbtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/all")
    public List<Transaction> getAll() {
        List<Transaction> transactions = this.transactionRepository.findAll();
        return transactions;
    }

    @GetMapping("/summary")
    public ArrayList<MonthlySummary> getSummary() {
        List<Transaction> transactions = this.transactionRepository.findAll();

        TransactionSummary transactionSummary = new TransactionSummary();

        transactionSummary.filterTransactions(transactions,"food");
        transactionSummary.calcMonthlySummary();
        ArrayList<MonthlySummary> monthlySummaries = transactionSummary.getMonthlySummaries();
        return monthlySummaries;
    }

    @PostMapping
    public List<Transaction> update(@RequestBody Transaction transaction) {
        this.transactionRepository.save(transaction);
        List<Transaction> transactions = this.transactionRepository.findAll();
        return transactions;
    }

    @DeleteMapping("/{tranId}")
    public List<Transaction> deleteTransaction(@PathVariable String tranId){
        this.transactionRepository.deleteById(tranId);
        List<Transaction> transactions = this.transactionRepository.findAll();
        return transactions;
    }

/*
    @GetMapping("/summary/{category}")
    @ResponseBody
    public MonthlySummary getSummary(@PathVariable String category) {
        MonthlySummary newMonthlySummary = new MonthlySummary(100,"Jan20");
        return MonthlySummary;

    }*/
    /*
    @GetMapping
    public String getSummary(@RequestParam(value ="category")String category) {
        return "test";
    }*/





}
