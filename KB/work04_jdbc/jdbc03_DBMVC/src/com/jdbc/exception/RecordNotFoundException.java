package com.jdbc.exception;
//Customer 추가시 중복체크
public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		this("This is RecordNotFoundException");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
}
