package com.jdbc.exception;
//Customer 추가시 중복체크
public class DuplicateSSNException extends Exception {

	public DuplicateSSNException() {
		this("This is DuplicateSSNException");
	}
	
	public DuplicateSSNException(String message) {
		super(message);
	}
}
