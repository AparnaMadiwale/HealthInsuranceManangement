package com.synechron.healthInsurance.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
	
	
@ResponseStatus(value = HttpStatus.NOT_FOUND  , reason ="This policy is not found in the system" )
public class NoSuchElementException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	
	public NoSuchElementException(String message) {
		
		super(message);
		System.out.println("Inside policyNot found"+ message);
		
	}

	}
