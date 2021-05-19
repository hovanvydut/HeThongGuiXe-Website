package hovanvy.core.customers.services;

import hovanvy.common.enums.MessageEnum;
import hovanvy.common.exceptions.CustomerExistingException;
import hovanvy.common.exceptions.CustomerStudentIdExistingException;
import hovanvy.common.exceptions.CustomerUsernameExistingException;
import hovanvy.common.exceptions.NullCustomerException;
import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.common.userdetails.UserDetails;
import hovanvy.core.customers.dao.CustomerDAO;
import hovanvy.core.customers.dao.CustomerDAOImpl;
import hovanvy.core.security.customeruserdetails.CustomerUserDetails;
import hovanvy.entity.Customer;
import hovanvy.util.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    private CustomerDAO customerDAO;
    
    public CustomerDetailsServiceImpl() {
        this.customerDAO = new CustomerDAOImpl();
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        return this.customerDAO.getAllCustomers();
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = this.customerDAO.getCustomerByUsername(username);
        return new CustomerUserDetails(customer);
    }

	@Override
	public Customer save(Customer customer) 
			throws NullCustomerException, CustomerStudentIdExistingException, CustomerUsernameExistingException {
		
		// check customer null
		if (customer == null) {
			throw new NullCustomerException();
		}
		
		// check if username is exist
		Customer customerInDb;
		
		try {
			customerInDb = this.customerDAO.getCustomerByUsername(customer.getUsername());
		} catch (UsernameNotFoundException e) {
			customerInDb = null;
		}
		
		if (customerInDb != null) {
			throw new CustomerUsernameExistingException();
		}
		
		// check if studentId is exist
		Optional<Customer> customerOpt = this.customerDAO.getCustomerByStudentId(customer.getStudent_id());
		
		if (customerOpt.isPresent()) {
			throw new CustomerStudentIdExistingException();
		}
		
		
		// hash password
		if (customer.getPassword() != null) {
			String encodedPassword = PasswordEncoder.encode(customer.getPassword());
			customer.setPassword(encodedPassword);
		}
		
		customer.setCreated_at(LocalDateTime.now());
		// store in db
		return this.customerDAO.save(customer);
	}

	@Override
	public void update(Customer customer) {
		
		this.customerDAO.update(customer);
	}
    
}
