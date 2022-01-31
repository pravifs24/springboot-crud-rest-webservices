package com.java.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcetion extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExcetion(String message) {
		super(message);
	}
}
