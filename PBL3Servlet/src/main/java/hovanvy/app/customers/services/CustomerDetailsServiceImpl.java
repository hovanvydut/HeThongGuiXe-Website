package hovanvy.app.customers.services;

import hovanvy.app.customers.dao.CustomerDAO;
import hovanvy.app.customers.dao.CustomerDAOImpl;
import hovanvy.app.security.customeruserdetails.CustomerUserDetails;
import hovanvy.common.enums.MessageEnum;
import hovanvy.common.exceptions.CustomerExistingException;
import hovanvy.common.exceptions.NullCustomerException;
import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.common.userdetails.UserDetails;
import hovanvy.entity.Customer;
import hovanvy.util.PasswordEncoder;

import java.util.List;

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
	public Customer save(Customer customer) throws CustomerExistingException, NullCustomerException {
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
			throw new CustomerExistingException();
		}
		
		// hash password
		if (customer.getPassword() != null) {
			String encodedPassword = PasswordEncoder.encode(customer.getPassword());
			customer.setPassword(encodedPassword);
		}
		
		// store in db
		return this.customerDAO.save(customer);
	}

	@Override
	public void update(Customer customer) {
		
		this.customerDAO.update(customer);
	}
    
}
