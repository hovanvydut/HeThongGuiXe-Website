package hovanvy.common.enums;

/**
 *
 * @author hovanvydut
 */

public enum MessageEnum {
    
    USERNAME_PASSWORD_WRONG("Username or Password is wrong");
    
    private String message;
    
    private MessageEnum(String msg) {
        this.message = msg;
    }
    
    public String get() {
        return this.message;
    }
    
}
