package com.cdac.exception_handler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dto.ApiResponse;

@RestControllerAdvice // to tell SC - spring bean containing exc handling advice meant for Rest
						// Controllers
public class GlobalExceptionHandler {
	// handle resource not found exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException e) {
		System.out.println("in catch - res not found...");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(e.getMessage()));
	}
	//handle validation(Presentation logic ) failures
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
	{
		System.out.println("in validation failure.....");
		/*
		 * In this case - extract List of rejected fields n 
		 * convert List -> Map<String - field name, String - err mesg>
		 */
		Map<String, String> rejectedFields = e.getFieldErrors() //List<FieldError>
		.stream() //Stream<FieldError>
		.collect(Collectors.toMap(FieldError::getField,
				FieldError::getDefaultMessage));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(rejectedFields);
	}

}
