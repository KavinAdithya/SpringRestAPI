package com.techcrack.restfulWebService.socialmedia.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime dateTime;
	private String description;
	private String message;
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime dateTime, String description, String message) {
		super();
		this.dateTime = dateTime;
		this.description = description;
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}
	
	public String getMessage() {
		return message;
	}
}
