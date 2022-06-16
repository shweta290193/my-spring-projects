package com.shweta.rest.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(MyCustomException.class)
	public ResponseEntity<String> handleAnyExcpetion(MyCustomException myCustomException)
	{
		System.out.println("*****inside GlobalExceptionHandlers.handleAnyExcpetion");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Some excpetion occurred",HttpStatus.BAD_REQUEST);
		return responseEntity;
		
	}
	
	//To handle NoSuchElementException in any Controller
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("No such id exists , please try again",HttpStatus.NOT_FOUND) ;
		
	}

	//below is an overidden inbuilt method from ResponseEntityExceptionHandler class, this class gives us built in exception handling methods 
	//we can configure our own logic in this method
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
	}


	
}
