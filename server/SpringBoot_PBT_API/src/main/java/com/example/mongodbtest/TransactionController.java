package com.example.mongodbtest;

import com.example.mongodbtest.summaryClasses.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/MonthCategorySummary")
    public List<MonthCategorySummary> getMonthCategorySummary() throws ParseException {
        List<Transaction> transactions = this.transactionRepository.findAll();

        Director director = new Director();
        MonthCategorySumBuilder summaryBuilder = new MonthCategorySumBuilder(transactions);
        director.buildMonthCategorySum(summaryBuilder);
        List<MonthCategorySummary> summaries = summaryBuilder.getSummaries();
        return summaries;

       /* List<Transaction> transactions = this.transactionRepository.findAll();

        TransactionSummary transactionSummary = new TransactionSummary();

        transactionSummary.filterTransactions(transactions,"Food");
        ArrayList<Transaction> results = transactionSummary.getGranularTransactions();
        ArrayList<MonthlySummary> results2 = transactionSummary.calcMonthlySummary();

        return results2;*/

        /*
        transactionSummary.calcMonthlySummary();
        ArrayList<MonthlySummary> monthlySummaries = transactionSummary.getMonthlySummaries();
        return results;*/


    }

    //same thing but for month summaries - no category
    @GetMapping("/MonthSummary")
    public List<MonthlySummary> getMonthSummary() throws ParseException {
        List<Transaction> transactions = this.transactionRepository.findAll();

        Director director = new Director();
        MonthSumBuilder summaryBuilder = new MonthSumBuilder(transactions);
        director.buildMonthCategorySum(summaryBuilder);
        List<MonthlySummary> summaries = summaryBuilder.getSummaries();
        return summaries;

    }



    @GetMapping("/test")
    public List<MonthlySummary> getTest() {
        MonthlySummary m1 = new MonthlySummary(
                "Jan-20",
                100

        );
        MonthlySummary m2 = new MonthlySummary(
                "Mar-20",
                500

        );
        MonthlySummary m3 = new MonthlySummary(
                "Apr-20",
                200

        );

        List<MonthlySummary> testSummary = new ArrayList<MonthlySummary>();
        testSummary.add(m1);
        testSummary.add(m2);
        testSummary.add(m3);

        return testSummary;
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

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World";
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
