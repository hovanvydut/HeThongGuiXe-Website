package hovanvy.common.enums;

/**
 *
 * @author hovanvydut
 */

public enum MessageEnum {
    
    USERNAME_PASSWORD_WRONG("username hoặc password không chính xác"),
    USERNAME_EXISTING("Tên tài khoản này đã tồn tại."),
    NULL_CUSTOMER("customer is null"),
    DATA_INVALID("Dữ liệu không hợp lệ");
    
    private String message;
    
    private MessageEnum(String msg) {
        this.message = msg;
    }
    
    public String get() {
        return this.message;
    }
    
}
