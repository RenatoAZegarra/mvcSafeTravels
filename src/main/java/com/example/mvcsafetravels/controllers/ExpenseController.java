package com.example.mvcsafetravels.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.mvcsafetravels.models.Expense;
import com.example.mvcsafetravels.services.ExpenseService;



import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseServ;
	

	
	@GetMapping("/expenses")
	public String allExpenses(Model model) {
		List<Expense> allExpenses = expenseServ.allExpenses();
		model.addAttribute("expenseList", allExpenses);
		return "expenselist.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String oneExpense(@PathVariable("id") Long id,Model model) {
		Expense oneExpense = expenseServ.findOne(id);
		model.addAttribute("oneExpense", oneExpense);
		return "expensedetails.jsp";
	}
	
	@GetMapping("/expenses/create")
	public String createExpense(@ModelAttribute("newExpense") Expense newExpense) {
		
		return "createexpense.jsp";
	}
	
	@PostMapping("/expenses/create")
	public String processCreateExpense(@Valid @ModelAttribute("newExpense")Expense newExpense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseServ.allExpenses());
			return "createexpense.jsp";
		} else {
			expenseServ.createExpense(newExpense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense oneExpense = expenseServ.findOne(id);
		model.addAttribute("oneExpense", oneExpense);
		return "editexpense.jsp";
	}
	
	
	@PutMapping("/expenses/edit/{id}")
	public String processEditExpense(@Valid @ModelAttribute("oneExpense") Expense oneExpense, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("oneExpense", expenseServ.findOne(id));
			return  "editexpense.jsp";
		} else {
		expenseServ.updateExpense(oneExpense);
		return "redirect:/expenses";
		}
	}
	
	
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
	    expenseServ.deleteExpense(id);
	    return "redirect:/expenses";
	}

	
	
	
	
	
	

}