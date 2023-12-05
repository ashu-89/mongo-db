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

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
      return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }



}
