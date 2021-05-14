package hovanvy.app.customers.dao;

import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.entity.Customer;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public interface CustomerDAO {
    
    Optional<Customer> findById(Integer id);
    
    List<Customer> getAllCustomers();
    
    Customer getCustomerByUsername(String username) throws UsernameNotFoundException;
    
    Customer save(Customer customer);
    
}
