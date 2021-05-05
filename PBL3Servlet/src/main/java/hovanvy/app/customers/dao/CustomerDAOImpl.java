package hovanvy.app.customers.dao;

import hovanvy.entity.Customer;
import hovanvy.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author hovanvydut
 */

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> getAllCustomers() {
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        List<Customer> customers = null;
        
        try {
            
            em.getTransaction().begin();
            
            customers = em.createQuery("FROM Customer", Customer.class).getResultList();
            
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return customers;
    }
    
}
