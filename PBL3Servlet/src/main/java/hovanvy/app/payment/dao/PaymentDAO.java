package hovanvy.app.payment.dao;

import hovanvy.entity.Payment;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface PaymentDAO {
    
    List<Payment> getAllPayments(Integer customerId);
    
}
