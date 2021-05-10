package hovanvy.util;

import hovanvy.common.userdetails.UserDetails;
import hovanvy.entity.Customer;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hovanvydut
 */

public class CustomerUtil {
    
    public static Customer getLoggedInUser(HttpServletRequest request) {
        UserDetails loggedInUserDetails = (UserDetails) request.getSession().getAttribute("loggedInUser");
        
        if (loggedInUserDetails == null)
            return null;
        
        Customer loggedInCustomer = loggedInUserDetails.getUser();
        return loggedInCustomer;
    }
}
