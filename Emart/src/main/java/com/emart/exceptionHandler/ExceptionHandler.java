package com.emart.exceptionHandler;

public class ExceptionHandler extends RuntimeException {

	private String Message;

	public ExceptionHandler(String Message) {
		super(Message);
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
