package hovanvy.core.payment.service;

import hovanvy.common.exceptions.CustomerNotFoundException;
import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public interface PaymentService {
    
    List<Payment> getAllPayments(Customer customer);
    
    Optional<Payment> getCurrentPayment(Integer customerId) throws CustomerNotFoundException;
}
