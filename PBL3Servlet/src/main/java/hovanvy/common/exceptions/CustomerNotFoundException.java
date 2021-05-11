package hovanvy.common.exceptions;

/**
 *
 * @author hovanvydut
 */

public class CustomerNotFoundException extends Exception {
    
    public CustomerNotFoundException() {
        super("Customer not found!");
    }
    
    public CustomerNotFoundException(String msg) {
        super(msg);
    }
    
    public CustomerNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
