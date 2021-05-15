package hovanvy.app.customers.services;

import hovanvy.common.exceptions.CustomerExistingException;
import hovanvy.common.exceptions.NullCustomerException;
import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.common.userdetailsservice.UserDetailsService;
import hovanvy.entity.Customer;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface CustomerDetailsService extends UserDetailsService {
    
    List<Customer> getAllCustomers();
    
    Customer save(Customer customer) throws CustomerExistingException, NullCustomerException;
    
    void update(Customer customer);
}
