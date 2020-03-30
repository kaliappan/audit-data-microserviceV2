package com.src.microservice.testing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SystemNotFoundException extends RuntimeException{

	public SystemNotFoundException(String message) {
		super(message);
	}
	
	
}