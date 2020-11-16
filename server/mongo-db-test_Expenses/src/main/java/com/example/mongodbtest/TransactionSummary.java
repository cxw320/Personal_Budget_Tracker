package com.example.mongodbtest;

import java.util.ArrayList;
import java.util.List;



public class TransactionSummary {

    private List<Transaction> granularTransactions;
    private ArrayList<MonthlySummary> allMonthlySummaries;

    public void filterTransactions(List<Transaction> transactions, String category){
        for(Transaction transaction: transactions){

            if(transaction.getCategory() == category){
                granularTransactions.add(transaction);
            }
        }
    }

    public List<Transaction> getGranularTransactions(){return granularTransactions;}

    public void calcMonthlySummary(){

        MonthlySummary jan = new MonthlySummary(100, "Jan-20");

        allMonthlySummaries.add(jan);
    }

    public ArrayList<MonthlySummary> getMonthlySummaries(){
        return allMonthlySummaries;
    }

}
