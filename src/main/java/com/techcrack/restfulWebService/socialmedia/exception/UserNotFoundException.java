package com.techcrack.restfulWebService.socialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -2941490316344214689L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
