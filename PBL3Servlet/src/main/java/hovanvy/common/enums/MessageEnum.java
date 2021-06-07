package hovanvy.common.enums;

/**
 *
 * @author hovanvydut
 */

public enum MessageEnum {
    
    USERNAME_PASSWORD_WRONG("Tài khoản hoặc mật khảu không chính xác"),
    USERNAME_EXISTING("Tên tài khoản này đã tồn tại."),
    NULL_CUSTOMER("customer is null"),
    DATA_INVALID("Dữ liệu không hợp lệ"),
    OLD_PASSWORD_NOT_MATCH("Mật khẩu cũ không khớp"),
    STUDENT_ID_EXISTING("Mã sinh viên đã tồn tại");
    
    private String message;
    
    private MessageEnum(String msg) {
        this.message = msg;
    }
    
    public String get() {
        return this.message;
    }
    
}
