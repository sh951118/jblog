package com.douzone.jblog.exception;

public class UserRepositoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserRepositoryException() {
		super("UserRepositoryException occurs");
	}
	
	public UserRepositoryException(String message) {
		super(message);
	}
}
