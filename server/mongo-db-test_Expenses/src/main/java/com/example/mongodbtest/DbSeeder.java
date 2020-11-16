package com.example.mongodbtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private TransactionRepository transactionRepository;


    public DbSeeder(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Transaction t1 = new Transaction(
                "ANGELINAS",
                1,
                true,
                "Food",
                -9.35
        );

        Transaction t2 = new Transaction(
                "Liberty Mutual",
                1,
                false,
                "Paycheck",
                2000.0
        );
        Transaction t3 = new Transaction(
                "Rosebud",
                 1,
                true,
                "Food",
                -47.52
        );
        Transaction t4 = new Transaction(
                "Apple.com/Bill",
                1,
                true,
                "Subscription",
                -0.99
        );


        //Drop existing collection
        this.transactionRepository.deleteAll();

        //add our hotels to the database
        this.transactionRepository.save(t1);
        this.transactionRepository.save(t2);
        this.transactionRepository.save(t3);
        this.transactionRepository.save(t4);

    }

}
