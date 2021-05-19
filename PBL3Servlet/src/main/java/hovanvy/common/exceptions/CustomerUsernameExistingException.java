package hovanvy.common.exceptions;

import hovanvy.common.enums.MessageEnum;

public class CustomerUsernameExistingException extends Exception {

	public CustomerUsernameExistingException() {
		super(MessageEnum.USERNAME_EXISTING.get());
	}
	
	public CustomerUsernameExistingException(String msg) {
		super(msg);
	}
	
	public CustomerUsernameExistingException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
