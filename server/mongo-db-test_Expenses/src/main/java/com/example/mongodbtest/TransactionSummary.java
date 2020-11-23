package com.example.mongodbtest;

import java.util.ArrayList;
import java.util.List;



public class TransactionSummary {

    private ArrayList<Transaction> granularTransactions;
    private ArrayList<MonthlySummary> allMonthlySummaries;

    public void filterTransactions(List<Transaction> transactions, String category){
        for(Transaction transaction: transactions){

            if(transaction.getCategory() == category){
                System.out.println(transaction.getCategory());
                granularTransactions.add(transaction);
            }
        }
    }

    public ArrayList<Transaction> getGranularTransactions(){return granularTransactions;}

    public void calcMonthlySummary(){

        MonthlySummary jan = new MonthlySummary("Jan-20", 100, 200);

        allMonthlySummaries.add(jan);
    }

    public ArrayList<MonthlySummary> getMonthlySummaries(){
        return allMonthlySummaries;
    }

}
