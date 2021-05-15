import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import hovanvy.util.EntityManagerUtil;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Close EntityMangerFactory");
		EntityManagerUtil.getInstance().closeEntityManagerFactory();
	}

}
