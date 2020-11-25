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
                "01-03-2020",
                true,
                "Food",
                -15.00
        );

        Transaction t2 = new Transaction(
                "Liberty Mutual",
                "02-01-2020",
                false,
                "Paycheck",
                1500.00
        );
        Transaction t3 = new Transaction(
                "Rosebud",
                 "01-04-2020",
                true,
                "Food",
                -47.52
        );
        Transaction t4 = new Transaction(
                "Pemberton Farms",
                "04-01-2020",
                true,
                "Food",
                -80.00
        );
        Transaction t5 = new Transaction(
                "SILVA realty",
                "01-01-2020",
                true,
                "Rent",
                -800.00
        );
        Transaction t6 = new Transaction(
                "SILVA realty",
                "02-01-2020",
                true,
                "Rent",
                -800.00
        );
        Transaction t7 = new Transaction(
                "SILVA realty",
                "03-01-2020",
                true,
                "Rent",
                -800.00
        );
        Transaction t8 = new Transaction(
                "SILVA realty",
                "04-01-2020",
                true,
                "Rent",
                -800.00
        );
        Transaction t9 = new Transaction(
                "Wegmans",
                "02-20-2020",
                true,
                "Food",
                -80.20
        );

        Transaction t10 = new Transaction(
                "Pemberton Farms",
                "03-20-2020",
                true,
                "Food",
                -120.20
        );

        //Drop existing collection
        this.transactionRepository.deleteAll();

        //add our hotels to the database
        this.transactionRepository.save(t1);
        this.transactionRepository.save(t2);
        this.transactionRepository.save(t3);
        this.transactionRepository.save(t4);
        this.transactionRepository.save(t5);
        this.transactionRepository.save(t6);
        this.transactionRepository.save(t7);
        this.transactionRepository.save(t8);
        this.transactionRepository.save(t9);
        this.transactionRepository.save(t10);

    }

}
