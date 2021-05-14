package hovanvy.common.exceptions;

import hovanvy.common.enums.MessageEnum;

/**
 * 
 * @author hovanvydut
 *
 */

public class NullCustomerException extends Exception{

	public NullCustomerException() {
        super(MessageEnum.NULL_CUSTOMER.get());
    }
    
    public NullCustomerException(String msg) {
        super(msg);
    }
    
    public NullCustomerException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}
