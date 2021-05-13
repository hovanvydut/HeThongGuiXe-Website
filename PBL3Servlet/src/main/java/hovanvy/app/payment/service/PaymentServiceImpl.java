package hovanvy.app.payment.service;

import hovanvy.app.customers.dao.CustomerDAO;
import hovanvy.app.customers.dao.CustomerDAOImpl;
import hovanvy.app.payment.dao.PaymentDAO;
import hovanvy.app.payment.dao.PaymentDAOImpl;
import hovanvy.common.exceptions.CustomerNotFoundException;
import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public class PaymentServiceImpl implements PaymentService {
    
    private final PaymentDAO paymentDAO;
    private final CustomerDAO customerDAO;
    
    public PaymentServiceImpl() {
        this.paymentDAO = new PaymentDAOImpl();
        this.customerDAO = new CustomerDAOImpl();
    }

    @Override
    public List<Payment> getAllPayments(Customer customer) {
        return this.paymentDAO.getAllPayments(customer.getID_customer());
    }

	@Override
	public Optional<Payment> getCurrentPayment(Integer customerId) throws CustomerNotFoundException {
		// check customer is exist
		Optional<Customer> customerOpt = this.customerDAO.findById(customerId);
		
		if (customerOpt.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		
		return this.paymentDAO.getCurrentPayment(customerOpt.get());
	}
    
    
}
