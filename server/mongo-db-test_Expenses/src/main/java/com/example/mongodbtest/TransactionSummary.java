package com.example.mongodbtest;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.text.SimpleDateFormat;


public class TransactionSummary {

    private ArrayList<Transaction> granularTransactions;
    private ArrayList<MonthlySummary> allMonthlySummaries;

    public TransactionSummary(){
        this.granularTransactions = new ArrayList<Transaction>();
        this.allMonthlySummaries = new ArrayList<MonthlySummary>();

    }

    public void filterTransactions(List<Transaction> transactions, String category){

        for(Transaction transaction: transactions){
            if(transaction.getCategory().equals(category)){
                System.out.println(transaction.getCategory());
                granularTransactions.add(transaction);
            }
        }
    }

    public ArrayList<Transaction> getGranularTransactions(){return granularTransactions;}

    public void setGranularTransactions(ArrayList<Transaction> granularTransactions) {
        this.granularTransactions = granularTransactions;
    }

    public void setAllMonthlySummaries(ArrayList<MonthlySummary> allMonthlySummaries) {
        this.allMonthlySummaries = allMonthlySummaries;
    }

    public ArrayList<MonthlySummary> getAllMonthlySummaries() {
        return allMonthlySummaries;
    }

    public ArrayList<Transaction> calcMonthlySummary() {

        //Step 1: Convert all months in granularTransactions to "MMM-yy"

        ArrayList<Transaction> holdTransactions = new ArrayList<Transaction>();

        for(Transaction transaction: granularTransactions){
            String date = transaction.getDate();
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate dateConverted = LocalDate.parse(date,dtf);

            TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstDayOfMonth();

            LocalDate firstDayOFMonth = dateConverted.with(temporalAdjuster);

            Transaction newDateTransaction = new Transaction(
                    transaction.getDescription(),
                    firstDayOFMonth.toString(),
                    transaction.getExpense_Flag(),
                    transaction.getCategory(),
                    transaction.getAmount());

            holdTransactions.add(newDateTransaction);



            //dateConverted.getMonth();
            //System.out.println(dateConverted);

            /*final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate dateConverted = LocalDate.parse(date, dtf);
            Month month = dateConverted.getMonth();

            System.out.println(month);*/

           /* DateTimeFormatter yearMonthFormat = DateTimeFormatter.ofPattern("MMM-yyyy");
            LocalDate dateConverted2 = LocalDate.parse(thisYearMonth, yearMonthFormat);
            transaction.updateYearMonthValue(dateConverted2);*/
        }

        return granularTransactions;

        //Step 2: Sum via Month groupings






    }

    public ArrayList<MonthlySummary> getMonthlySummaries(){
        return allMonthlySummaries;
    }


}
