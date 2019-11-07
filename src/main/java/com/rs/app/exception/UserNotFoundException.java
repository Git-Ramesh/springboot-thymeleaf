package com.rs.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found!")
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3081407595552042332L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable th) {
		super(message, th);
	}
}
