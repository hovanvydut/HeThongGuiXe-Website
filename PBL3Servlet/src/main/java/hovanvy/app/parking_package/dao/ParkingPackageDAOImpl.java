/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hovanvy.app.parking_package.dao;

import hovanvy.entity.ParkingPackage;
import hovanvy.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author hovanvydut
 */

public class ParkingPackageDAOImpl implements ParkingPackageDAO{

    @Override
    public List<ParkingPackage> getAllParkingPackages() {
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        List<ParkingPackage> result = null;
        
        try {
            em.getTransaction().begin();
            
            result = em.createQuery("SELECT u FROM ParkingPackage u", ParkingPackage.class)
                        .getResultList();
            
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
    
}
