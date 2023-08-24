package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Expense;
import com.masai.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService es;
	
	@PostMapping("/log")
	public ResponseEntity<String> logExpense(@RequestBody @Valid Expense ex){
		es.saveExpense(ex);
		return new ResponseEntity<String>("Expense logged successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Expense>> getAllExpenses(){
		return new ResponseEntity<List<Expense>>(es.getAllExpenses(), HttpStatus.OK);
	}
	
//	@GetMapping("/users/list")
//	public ResponseEntity<List<Expense>> getUsersExpenses(){
//		return new ResponseEntity<List<Expense>>(es.getList(name), HttpStatus.OK);
//	}
	
	
}
