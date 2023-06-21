package com.example.mvcsafetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvcsafetravels.models.Expense;
import com.example.mvcsafetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;

	//find All
    public List<Expense> allExpenses() {
    	return expenseRepository.findAll();
    }
    
    //Create
    public Expense createExpense(Expense newExpense) {
    	return expenseRepository.save(newExpense);
    }
    
    //find One
    public Expense findOne(Long id) {
    	Optional<Expense> optionalExpense = expenseRepository.findById(id);
    	if(optionalExpense.isPresent()) {
    		return optionalExpense.get();
    	} else {
    		return null;
    	}
    }
    
    //Update
    public Expense updateExpense(Expense oneExpense) {
    	return expenseRepository.save(oneExpense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
