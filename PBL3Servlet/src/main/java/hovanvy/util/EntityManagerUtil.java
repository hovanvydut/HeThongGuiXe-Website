package hovanvy.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hovanvydut
 */
public class EntityManagerUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PBL3_Unit";
    private static EntityManagerUtil _instance;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    private EntityManagerUtil() {
        
    }
    
    // singleton pattern
    public static EntityManagerUtil getInstance() {
        if (_instance == null) {
            _instance = new EntityManagerUtil();
        }
        return _instance;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   
}
