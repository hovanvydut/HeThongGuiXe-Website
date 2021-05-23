package hovanvy.common.listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import hovanvy.util.EntityManagerUtil;

public class MyServletContextListener implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Server is running");
		EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.getTransaction().commit();
			System.out.println("Connect to database successfully");
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Close EntityMangerFactory");
		EntityManagerUtil.getInstance().closeEntityManagerFactory();
	}

}
