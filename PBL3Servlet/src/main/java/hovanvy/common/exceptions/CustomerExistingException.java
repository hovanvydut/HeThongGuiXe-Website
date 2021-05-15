package hovanvy.common.exceptions;

import hovanvy.common.enums.MessageEnum;

/**
 * 
 * @author hovanvydut
 *
 */

public class CustomerExistingException extends Exception {
	
	public CustomerExistingException() {
		super(MessageEnum.USERNAME_EXISTING.get());
	}
	
	public CustomerExistingException(String msg) {
        super(msg);
    }
    
    public CustomerExistingException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}
