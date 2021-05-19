package hovanvy.common.exceptions;

import hovanvy.common.enums.MessageEnum;

public class CustomerStudentIdExistingException extends Exception {
	
	public CustomerStudentIdExistingException() {
		super(MessageEnum.STUDENT_ID_EXISTING.get());
	}
	
	public CustomerStudentIdExistingException(String msg) {
		super(msg);
	}
	
	public CustomerStudentIdExistingException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
