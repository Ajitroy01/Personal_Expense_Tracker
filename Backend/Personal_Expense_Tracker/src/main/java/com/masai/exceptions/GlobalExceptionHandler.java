package com.masai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException e, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodExceptionHandler(MethodArgumentNotValidException e, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorDetails> badExceptionHandler(BadCredentialsException e, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
}
