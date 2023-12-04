package com.ashutoshpathak.mongodb.controller;

import com.ashutoshpathak.mongodb.model.Expense;
import com.ashutoshpathak.mongodb.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    public void updateExpense(){}

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
      return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    public void getExpenseByName(){}

    public void deleteExpense(){}



}
