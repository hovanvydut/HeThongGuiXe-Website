package hovanvy.core.customers.dao;

import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.entity.Customer;
import hovanvy.entity.Customer_;
import hovanvy.util.EntityManagerUtil;
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

    @Override
    public Customer getCustomerByUsername(String username) throws UsernameNotFoundException {
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        Customer customerInDB = null;

        try {

            em.getTransaction().begin();

            String queryString = "SELECT c FROM Customer c WHERE c.username = ?1";

            TypedQuery<Customer> query = em.createQuery(queryString, Customer.class);

            customerInDB = query.setParameter(1, username).getSingleResult();

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        if (customerInDB == null) {
            throw new UsernameNotFoundException("Username " + username + " has not found!");
        }

        return customerInDB;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        Customer customerInDB = null;

        try {

            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            
            cq.select(root);
            cq.where(cb.equal(root.get(Customer_.ID_customer), id));
            
            TypedQuery<Customer> query = em.createQuery(cq);
            customerInDB = query.getSingleResult();
            
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(customerInDB);
    }

	@Override
	public Customer save(Customer customer) {
		EntityManager em = EntityManagerUtil.getInstance().getEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(customer);

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return customer;
	}

	@Override
	public void update(Customer customer) {
		
		EntityManager em = EntityManagerUtil.getInstance().getEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(customer);

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
	}

}
