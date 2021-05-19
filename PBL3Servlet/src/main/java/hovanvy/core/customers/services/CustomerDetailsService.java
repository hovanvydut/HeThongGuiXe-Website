package hovanvy.core.customers.services;

import hovanvy.common.exceptions.CustomerExistingException;
import hovanvy.common.exceptions.CustomerStudentIdExistingException;
import hovanvy.common.exceptions.CustomerUsernameExistingException;
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
    
    Customer save(Customer customer) throws NullCustomerException, 
    			CustomerStudentIdExistingException, CustomerUsernameExistingException;
    
    void update(Customer customer);
}
