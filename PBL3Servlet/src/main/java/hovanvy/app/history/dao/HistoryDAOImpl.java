package hovanvy.app.history.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import hovanvy.entity.ParkingHistory_;
import hovanvy.util.EntityManagerUtil;
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
        List<ParkingHistory> history = null;
        
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
    
}
