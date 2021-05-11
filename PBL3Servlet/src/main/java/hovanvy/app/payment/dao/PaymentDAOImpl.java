package hovanvy.app.payment.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.Payment;
import hovanvy.entity.Payment_;
import hovanvy.util.EntityManagerUtil;
import java.util.ArrayList;
import java.util.List;
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
    
}
