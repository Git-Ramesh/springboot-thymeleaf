package com.rs.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User already exists")
public class UserAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = -5024127346977457757L;

	public UserAlreadyExists(String message) {
		super(message);
	}

	public UserAlreadyExists(String message, Throwable th) {
		super(message, th);
	}
}
