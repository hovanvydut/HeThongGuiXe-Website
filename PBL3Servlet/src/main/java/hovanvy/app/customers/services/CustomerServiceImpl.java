package hovanvy.app.customers.services;

import hovanvy.app.customers.dao.CustomerDAO;
import hovanvy.app.customers.dao.CustomerDAOImpl;
import hovanvy.entity.Customer;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO CustomerDAO;
    
    public CustomerServiceImpl() {
        this.CustomerDAO = new CustomerDAOImpl();
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        return this.CustomerDAO.getAllCustomers();
    }
    
}
