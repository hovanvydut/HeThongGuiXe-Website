package hovanvy.common.crud_dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import hovanvy.entity.Customer;
import hovanvy.entity.Customer_;
import hovanvy.util.EntityManagerUtil;

public interface CrudDAO<T, ID> {

	default Optional<T> getOne(ID id, Class<T> E) {
		EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        T customerInDB = null;

        try {

            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(E);
            Root<T> root = cq.from(E);
            
            cq.select(root);
//            cq.where(cb.equal(root.get(E.), id));
//            
//            TypedQuery<Customer> query = em.createQuery(cq);
//            customerInDB = query.getSingleResult();
            
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(customerInDB);
	}
}
