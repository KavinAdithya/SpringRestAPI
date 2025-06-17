package com.techcrack.restfulWebService.socialmedia.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(
	        NoHandlerFoundException ex,
	        HttpHeaders headers,
	        HttpStatusCode status,
	        WebRequest request
	    ) {
		 ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		 
		 return new ResponseEntity<Object>(errorDetails, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request
			) {
		
		ErrorDetails error = new ErrorDetails(
				LocalDateTime.now(), 
				"Total Errors are : " + ex.getErrorCount() + " First Error Message is : " + ex.getFieldError().getDefaultMessage(), 
				"Do it Again");
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}	