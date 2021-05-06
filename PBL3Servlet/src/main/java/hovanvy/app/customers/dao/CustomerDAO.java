package hovanvy.app.customers.dao;

import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.entity.Customer;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface CustomerDAO {
    
    List<Customer> getAllCustomers();
    
    Customer getCustomerByUsername(String username) throws UsernameNotFoundException;
    
}
