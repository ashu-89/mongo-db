package com.ashutoshpathak.mongodb.service;

import com.ashutoshpathak.mongodb.model.Expense;
import com.ashutoshpathak.mongodb.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

//    public void addExpense(Expense expense){
//        // Validate expense fields
//        if (expense.getExpenseName() == null || expense.getExpenseAmount() == null || expense.getExpenseCategory() == null) {
//            // Handle validation error (throw exception or log error)
//            // For now, let's just log an error and return
//            System.err.println("Invalid expense data: " + expense);
//            return;
//        }
//
//        // Log the expense details (for debugging)
//        System.out.println("Adding expense: " + expense);
//
//        // Insert the expense into the repository
//        expenseRepository.insert(expense);
//    }


    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense by id %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String expenseName){
        return expenseRepository.findByExpenseName(expenseName)
                .orElseThrow( () -> new RuntimeException(
                        String.format("Expense with name %s not found." , expenseName)
                ));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);

    }



}
