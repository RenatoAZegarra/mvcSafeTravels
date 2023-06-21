//package com.example.mvcsafetravels.controllers;
//
//	import com.example.mvcsafetravels.models.Expense;
//	import com.example.mvcsafetravels.services.ExpenseService;
//	import org.springframework.stereotype.Controller;
//	import org.springframework.ui.Model;
//	import org.springframework.web.bind.annotation.*;
//
//	import java.util.List;
//
//	@Controller
//	@RequestMapping("/api")
//	public class ApiController {
//	    private final ExpenseService expenseService;
//
//	    public ApiController(ExpenseService expenseService) {
//	        this.expenseService = expenseService;
//	    }
//
//	    @GetMapping("")
//	    public String getAllExpenses(Model model) {
//	        List<Expense> expenses = expenseService.allExpenses();
//	        model.addAttribute("expenses", expenses);
//	        return "expenselist.jsp";
//	    }
//
//	    @GetMapping("/create")
//	    public String showCreateForm(Model model) {
//	        Expense expense = new Expense();
//	        model.addAttribute("expense", expense);
//	        return "createexpense.jsp";
//	    }
//
//	    @GetMapping("/{id}")
//	    public String getExpenseDetails(@PathVariable("id") Long id, Model model) {
//	        Expense expense = expenseService.findOne(id);
//	        model.addAttribute("expense", expense);
//	        return "expensedetail.jsp";
//	    }
//
//	    @GetMapping("/{id}/edit")
//	    public String showEditForm(@PathVariable("id") Long id, Model model) {
//	        Expense expense = expenseService.findOne(id);
//	        model.addAttribute("expense", expense);
//	        return "editexpense.jsp";
//	    }
//	    
//	    @PostMapping("/create")
//	    public String createExpense(@ModelAttribute("expense") Expense expense) {
//	        expenseService.create(expense);
//	        return "redirect:/expenses";
//	    }
//
//	    @PostMapping("/{id}/edit")
//	    public String updateExpense(@ModelAttribute("expense") Expense expense) {
//	        expenseService.update(expense);
//	        return "redirect:/expenses";
//	    }
//
//	    @DeleteMapping("/{id}/delete")
//	    public String deleteExpense(@PathVariable("id") Long id) {
//	        expenseService.delete(id);
//	        return "redirect:/expenses";
//	    }
//	}
