package hovanvy.app.customers.services;

import hovanvy.common.userdetailsservice.UserDetailsService;
import hovanvy.entity.Customer;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface CustomerDetailsService extends UserDetailsService {
    
    List<Customer> getAllCustomers();
    
}
