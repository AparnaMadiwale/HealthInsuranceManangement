package com.synechron.healthInsurance.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.hibernate.ObjectNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)  
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleNotFound(NoSuchElementException e) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(IllegalArgumentException.class)
	 * 
	 * @ResponseBody public ErrorResponse handleIllegal(IllegalArgumentException e)
	 * { return new ErrorResponse("InvalidInput", e); }
	 */
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExp(Exception exe)
	{
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Invalid Input");
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({MethodArgumentTypeMismatchException.class})
	public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex) {
		System.out.println(ex.getClass().getName());
		
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Invalid Input...Please try entering valid input");
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}

}
