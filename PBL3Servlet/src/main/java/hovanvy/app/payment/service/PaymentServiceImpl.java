package hovanvy.app.payment.service;

import hovanvy.app.payment.dao.PaymentDAO;
import hovanvy.app.payment.dao.PaymentDAOImpl;
import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public class PaymentServiceImpl implements PaymentService {
    
    private final PaymentDAO paymentDAO;
    
    public PaymentServiceImpl() {
        this.paymentDAO = new PaymentDAOImpl();
    }

    @Override
    public List<Payment> getAllPayments(Customer customer) {
        return this.paymentDAO.getAllPayments(customer.getID_customer());
    }
    
}
