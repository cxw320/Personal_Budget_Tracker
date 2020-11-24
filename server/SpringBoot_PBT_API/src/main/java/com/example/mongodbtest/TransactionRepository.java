package com.example.mongodbtest;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

// repository extends JPARepository

public interface TransactionRepository extends MongoRepository<Transaction,String> {
    @DeleteQuery
    void deleteById(String id);

}
