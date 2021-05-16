package hovanvy.core.payment.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public interface PaymentDAO {
    
    List<Payment> getAllPayments(Integer customerId);
    
    Optional<Payment> getCurrentPayment(Customer customer);
}
