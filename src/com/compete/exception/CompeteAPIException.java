package com.compete.exception;

public class CompeteAPIException extends Exception {

	public CompeteAPIException(String message, Throwable t){
		super(message, t);
	}

	public CompeteAPIException(String message){
		super(message);
	}
	
	public CompeteAPIException(String message, int errorCode){
		super(message);
	}
}
