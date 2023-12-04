package com.ashutoshpathak.mongodb.repository;

import com.ashutoshpathak.mongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense,String> {
}
