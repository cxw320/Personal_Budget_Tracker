package com.example.mongodbtest.summaryClasses;

public class Director {

    private SummaryBuilder summaryBuilder;

    public void setBuilder(SummaryBuilder summaryBuilder){
        this.summaryBuilder = summaryBuilder;
    }

    public void buildMonthCategorySum(SummaryBuilder summaryBuilder){
        summaryBuilder.setFilter();
        summaryBuilder.setDate();
        summaryBuilder.setCategory();
        summaryBuilder.calcSums();
    }

    public void buildMonthSum(SummaryBuilder summaryBuilder){
        summaryBuilder.setFilter();
        summaryBuilder.setDate();
        summaryBuilder.setCategory();
        summaryBuilder.calcSums();
    }




}


/*
class Director is
    private field builder:Builder

    // The director works with any builder instance that the
    // client code passes to it. This way, the client code may
    // alter the final type of the newly assembled product.
    method setBuilder(builder:Builder)
        this.builder = builder

    // The director can construct several product variations
    // using the same building steps.
    method constructSportsCar(builder: Builder) is
        builder.reset()
        builder.setSeats(2)
        builder.setEngine(new SportEngine())
        builder.setTripComputer(true)
        builder.setGPS(true)

    method constructSUV(builder: Builder) is
        // ...

 */
