package hovanvy.app;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.common.enums.PathJsp;
import hovanvy.entity.Customer;
import hovanvy.util.CustomerUtil;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/home"}, name = "HomeServlet")
public class HomeServlet extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Customer loggedCustomer = CustomerUtil.getLoggedInUser(request);
    	request.setAttribute("loggedInCustomer", loggedCustomer);
    	
        request.getRequestDispatcher(PathJsp.HOME.getPath()).forward(request, response);
    }
    
}
