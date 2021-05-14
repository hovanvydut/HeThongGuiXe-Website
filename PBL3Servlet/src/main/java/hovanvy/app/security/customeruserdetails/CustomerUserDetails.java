package hovanvy.app.security.customeruserdetails;

import hovanvy.common.userdetails.UserDetails;
import hovanvy.entity.Customer;

/**
 *
 * @author hovanvydut
 */

public class CustomerUserDetails implements UserDetails {

    private final Customer customer;
    
    public CustomerUserDetails(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getUsername();
    }

    @Override
    public boolean isEnabled() {
    	if ((customer.getCard_id() == null) || customer.getCard_id().equals("")) {
    		return false;
    	}
        
    	return true;
    }
    
    @Override
    public Customer getUser() {
        return this.customer;
    }
}
