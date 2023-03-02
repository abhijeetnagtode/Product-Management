package com.emart.globalexceptionhandler;

import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	// private String message;

	public GlobalExceptionHandler(String message) {
		super(message);
	}

	@ExceptionHandler()
	public ResponseEntity<HashMap<String, Object>> exceptionHandler(GlobalExceptionHandler exception) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("Date: ", new Date());
		hm.put("Message: ", exception.getMessage());
		return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.FORBIDDEN);
	}

}
