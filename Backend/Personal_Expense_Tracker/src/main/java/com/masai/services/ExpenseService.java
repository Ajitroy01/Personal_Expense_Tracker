package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Expense;
import com.masai.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	
	public void saveExpense(Expense ex) {
		expenseRepo.save(ex);
	}
	
	public List<Expense> getAllExpenses(){
		return expenseRepo.findAllByOrderByDateAsc();
	}
	
	public List<Expense> getList(){
		return expenseRepo.findAll();
	}
}
