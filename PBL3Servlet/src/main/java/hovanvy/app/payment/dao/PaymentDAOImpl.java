package hovanvy.app.payment.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import hovanvy.entity.Payment_;
import hovanvy.util.EntityManagerUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author hovanvydut
 */

public class PaymentDAOImpl implements PaymentDAO {
	
	/**
	 * Get all customer's payments
	 * @param Integer customerId
	 * @return List<Payment>
	 */
    @Override
    public List<Payment> getAllPayments(Integer customerId) {
    	EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        List<Payment> result = new ArrayList<>();
        
        Customer customer = new Customer();
        customer.setID_customer(customerId);
        try {
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
            Root<Payment> root = cq.from(Payment.class);

            cq.select(root);
            cq.where(cb.equal(root.get(Payment_.customer), customer));

            TypedQuery<Payment> query = em.createQuery(cq);

            result = query.getResultList();

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return result;
    }

	@Override
	public Optional<Payment> getCurrentPayment(Customer customer) {
		
		EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        Payment result = null;
        LocalDate now = LocalDate.now();
        
        try {
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
            Root<Payment> root = cq.from(Payment.class);

            cq.select(root);
            cq.where(
            		cb.and(
            				cb.equal(root.get(Payment_.customer), customer),
            				// start_date <= now <= end_date
		            		cb.lessThanOrEqualTo(root.get(Payment_.start_date), now),
		            		cb.greaterThanOrEqualTo(root.get(Payment_.end_date), now)
		            )
            );

            TypedQuery<Payment> query = em.createQuery(cq);
            
            List<Payment> payments = query.getResultList();
            
            if (payments.size() > 0) {
            	result = payments.get(0);
            }
            
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(result);
	}
    
}
