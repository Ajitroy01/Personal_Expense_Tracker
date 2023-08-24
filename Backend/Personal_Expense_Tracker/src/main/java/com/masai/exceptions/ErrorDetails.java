package com.masai.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {

	private LocalDateTime timestamp = LocalDateTime.now();
	private String  message;
	private String description;
}
