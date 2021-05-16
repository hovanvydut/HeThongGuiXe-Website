/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hovanvy.core.parking_package.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.ParkingPackage;
import hovanvy.entity.ParkingPackage_;
import hovanvy.entity.Payment;
import hovanvy.util.EntityManagerUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

public class ParkingPackageDAOImpl implements ParkingPackageDAO {

	/**
	 * Get all package available
	 * @param
	 * @return List<ParkingPackage>
	 */
    @Override
    public List<ParkingPackage> getAllParkingPackages() {
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        List<ParkingPackage> result = new ArrayList<>();

        try {
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ParkingPackage> cq = cb.createQuery(ParkingPackage.class);
            Root<ParkingPackage> root = cq.from(ParkingPackage.class);

            cq.select(root);
            cq.where(cb.isTrue(root.get(ParkingPackage_.visible)));

            TypedQuery<ParkingPackage> query = em.createQuery(cq);

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
    public void save(ParkingPackage parkingPackage) {

        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(parkingPackage);

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    /**
     * Register ParkingPackage for Customer
     * @param customer
     * @param parkingPackage
     * @return Payment after register successfully or null if failed
     */
    @Override
    public Payment register(Customer customer, ParkingPackage parkingPackage) {

        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        LocalDate now = LocalDate.now();

        // create new payment
        Payment payment = null;

        try {
            em.getTransaction().begin();
            
            payment = new Payment();
            payment.setCustomer(customer);
            payment.setPrice(parkingPackage.getPrice());
            payment.setDescription(parkingPackage.getDescription());
            payment.setStart_date(now);
            payment.setEnd_date(now.plusDays(parkingPackage.getDuration()));
            payment.setPaid_at(null);
            
            // store in db
            em.persist(payment);

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return payment;
    }
    
    /**
     * Find ParkingPackage by id
     * @param ParkingPackage id
     * @return ParkingPackage
     */
    @Override
    public Optional<ParkingPackage> findById(Integer id) {
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        ParkingPackage parkingPackageInDB = null;

        try {

            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ParkingPackage> cq = cb.createQuery(ParkingPackage.class);
            Root<ParkingPackage> root = cq.from(ParkingPackage.class);
            
            cq.select(root);
            cq.where(cb.equal(root.get(ParkingPackage_.ID_package), id));
            
            TypedQuery<ParkingPackage> query = em.createQuery(cq);
            parkingPackageInDB = query.getSingleResult();
            
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(parkingPackageInDB);
    }

}
