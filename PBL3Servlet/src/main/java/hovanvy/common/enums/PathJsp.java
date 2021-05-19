package hovanvy.common.enums;

/**
 *
 * @author hovanvydut
 */

public enum PathJsp {
    CUSTOMER_INFO("/templates/pages/customers/customer_info.jsp"),
    HISTORY("/templates/pages/history/history.jsp"),
    PACKAGE_LIST("/templates/pages/package_registration/package_list.jsp"),
    LOGIN("/templates/pages/login/login.jsp"),
    SIGN_UP("/templates/pages/signup/signup.jsp"),
    FORGOT_PASSWORD("/templates/pages/signup/forgot_password.jsp"),
    RESET_PASSWORD("/templates/pages/signup/reset_password.jsp"),
    HOME("/templates/pages/home/home.jsp");
    
    private String path;
    
    private PathJsp(String path) {
        this.path = path;
    }   
    
    public String getPath() {
        return this.path;
    }
}
