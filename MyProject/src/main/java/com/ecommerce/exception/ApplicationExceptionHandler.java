package com.ecommerce.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
		
		Map<String, String> response = new HashMap<>();
		response.put("error message", productNotFoundException.getMessage());
		response.put("status", HttpStatus.BAD_REQUEST.toString());
		
		return ResponseEntity.ok(response);
	}

}
