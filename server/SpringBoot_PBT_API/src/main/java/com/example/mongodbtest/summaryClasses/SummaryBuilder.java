package com.example.mongodbtest.summaryClasses;

import com.example.mongodbtest.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface SummaryBuilder {


    public void setFilter();
    public void setDate();
    public void setCategory();
    public void calcSums();

}
