package hovanvy.app.history.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import hovanvy.entity.ParkingHistory_;
import hovanvy.util.EntityManagerUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
  @author hovanvydut
 */

public class HistoryDAOImpl implements HistoryDAO{

    @Override
    public List<ParkingHistory> getAllHistory(Integer userId) {
    	
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        List<ParkingHistory> history = new ArrayList<>();
        
        try {
            em.getTransaction().begin();
            
            Customer customer = new Customer();
            customer.setID_customer(userId);
            
            // use criteria JPA
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ParkingHistory> cq = cb.createQuery(ParkingHistory.class);
            Root<ParkingHistory> root = cq.from(ParkingHistory.class);
            
            cq.select(root);
            cq.where(cb.equal(root.get(ParkingHistory_.customer), customer));
            cq.orderBy(cb.desc(root.get(ParkingHistory_.check_out_at)));

            TypedQuery<ParkingHistory> query = em.createQuery(cq);
            query.setMaxResults(3);
            
            history = query.getResultList();
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
             em.close();
        }
        
        return history;
    }

    @Override
    public List<ParkingHistory> filterHistory(Customer customer, 
    		LocalDateTime fromDate, LocalDateTime toDate) {
    	
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        List<ParkingHistory> history = new ArrayList<>();
        
        try {
            em.getTransaction().begin();
            
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ParkingHistory> cq = cb.createQuery(ParkingHistory.class);
            Root<ParkingHistory> root = cq.from(ParkingHistory.class);
            
            cq.where(cb.and(
                    cb.equal(root.get(ParkingHistory_.customer), customer),
                    cb.greaterThan(root.get(ParkingHistory_.check_in_at), fromDate),
                    cb.lessThan(root.get(ParkingHistory_.check_in_at), toDate)
                ));
            
            TypedQuery<ParkingHistory> query = em.createQuery(cq);
            history = query.getResultList();
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return history;
    }
    
}
