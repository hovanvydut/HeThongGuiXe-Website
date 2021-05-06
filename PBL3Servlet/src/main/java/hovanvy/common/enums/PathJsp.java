package hovanvy.common.enums;

/**
 *
 * @author hovanvydut
 */

public enum PathJsp {
    CUSTOMER_INFO("/templates/pages/customers/customer_info.jsp"),
    HISTORY("/templates/pages/history/history.jsp"),
    PACKAGE_LIST("/templates/pages/package_registration/package_list.jsp"),
    LOGIN("/templates/pages/login/login.jsp");
    
    private String path;
    
    private PathJsp(String path) {
        this.path = path;
    }   
    
    public String getPath() {
        return this.path;
    }
}
