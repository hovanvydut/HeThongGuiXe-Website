package hovanvy.common.exceptions;

/**
 *
 * @author hovanvydut
 */
public class UsernameNotFoundException extends Exception {
    
    public UsernameNotFoundException(String msg) {
        super(msg);
    }
    
    public UsernameNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}
