package com.example.mongodbtest.summaryClasses;

import com.example.mongodbtest.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonthCategorySumBuilder implements SummaryBuilder{

   // private MonthCategorySum monthCategorySum;
    private List<MonthCategorySummary> summaries;
    private List<Transaction> transactionsGranular;
    private List<Transaction> tempHold;
    private List<Transaction> tempHold2;

    public MonthCategorySumBuilder(List<Transaction> transactions){
        this.transactionsGranular= transactions;
        this.reset();
    }

    public void reset(){
        this.summaries = new ArrayList<MonthCategorySummary>();
    }

    public void setFilter(){
        //LATER ON, REACT FRONT END WILL CREATE AN OBJECT THAT REPRESENTS THE FILTER
        // THAT OBJECT WILL BE SENT VIA A POST REQUEST IN THE BODY
        // THAT OBJECT WILL BE PART OF THE MonthCategorySumBuilder constructor

    }

    public void setDate(){

        //THIS TURNS ALL THE DATE TO THE 1ST DAY OF THE MONTH TO ENABLE MONTH SUMMARY
        // ADDS THE NEW TRANSACTION TO A NEW EMPTY ARRAYLIST
        tempHold = new ArrayList<Transaction>();
        tempHold2 = new ArrayList<Transaction>();

        for(Transaction transaction: transactionsGranular){
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
            //some libraries that copy original objects to a temp
            // Apache Common
            // maybe copy over permanently
            // Transfer Objects / Value Objects. Java pojos, transport data through layers of application, no state
            // data grouped by folders (service classes) - traditionally, you have controller
            // Service Layer = back-end logic, inside of Spring its called "service"
            // struts uses sessionBean
            // service handles all the logic
            //

            tempHold.add(newDateTransaction);

        }


    }

    public void setCategory(){

    }

    public void calcSums(){

        Map<String, Double> foodMonthlySums =
                tempHold.stream()
                .filter(transaction -> transaction.getCategory().equals("Food"))
                .collect(Collectors.groupingBy(Transaction::getDate,
                Collectors.summingDouble(Transaction::getAmount)));

        foodMonthlySums.forEach((key, value) -> summaries.add(new MonthCategorySummary(key, value*-1,0)));


        Map<String, Double> rentMonthlySums =
                tempHold.stream()
                        .filter(transaction -> transaction.getCategory().equals("Rent"))
                        .collect(Collectors.groupingBy(Transaction::getDate,
                                Collectors.summingDouble(Transaction::getAmount)));


        summaries.forEach((summary)->{
            rentMonthlySums.forEach((key,value)->{
                if (key.equals(summary.getMonth())) {
                    summary.setRentAmount(value*-1);
                }else{
                    summaries.add(new MonthCategorySummary(key, 0, value*-1));
                }
            });
        });


        rentMonthlySums.forEach((key,value)->{
            summaries.forEach((summary)->{
                if(key.equals(summary.getMonth())){
                    summary.setRentAmount(value*-1);
                }
            })
        })

    }

    public List<MonthCategorySummary> getSummaries(){
        List<MonthCategorySummary> finalSummaries = this.summaries;
        this.reset();
        return finalSummaries;
    }


}
