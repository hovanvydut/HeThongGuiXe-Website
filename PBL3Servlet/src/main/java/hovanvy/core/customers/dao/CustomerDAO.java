package hovanvy.core.customers.dao;

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
    
    Optional<Customer> getCustomerByStudentId(String studentId);
    
    Customer save(Customer customer);
    
    void update(Customer customer);
    
}
