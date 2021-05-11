package hovanvy.app.payment.service;

import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface PaymentService {
    
    List<Payment> getAllPayments(Customer customer);
    
}
