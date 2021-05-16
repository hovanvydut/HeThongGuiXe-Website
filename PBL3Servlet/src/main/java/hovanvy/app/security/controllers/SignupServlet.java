package hovanvy.app.security.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.common.enums.PathJsp;
import hovanvy.common.exceptions.CustomerExistingException;
import hovanvy.common.exceptions.NullCustomerException;
import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.core.customers.services.CustomerDetailsService;
import hovanvy.core.customers.services.CustomerDetailsServiceImpl;
import hovanvy.entity.Customer;
import hovanvy.util.CustomerUtil;

/**
 * 
 * @author hovanvydut
 *
 */

// -----> CustomerValidatorFilter ----(req, res)----> SignupServlet
@WebServlet(urlPatterns = {"/sign-up"}, name = "SignupServlet")
public class SignupServlet extends HttpServlet {
	
	private final CustomerDetailsService customerService = new CustomerDetailsServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		

        Customer customer = CustomerUtil.getLoggedInUser(request);
        
        // if has logged in, redirect to previous page
        if (customer != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        
		request.getRequestDispatcher(PathJsp.SIGN_UP.getPath()).forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		RequestDispatcher dp = request.getRequestDispatcher(PathJsp.SIGN_UP.getPath());
		
		// see CustomerValidatorFilter
		Customer customer = (Customer) request.getAttribute("customer");
		
		try {
			
			// sign up customer
			this.customerService.save(customer);
			
		} catch (CustomerExistingException e) {
			request.setAttribute("customer", customer);
			request.setAttribute("errorMessage", e.getMessage());
			dp.forward(request, response);
			return;
		} catch (NullCustomerException e) {
			response.sendError(500);
			return;
		}
		
		// sign up sucess
		response.sendRedirect(request.getContextPath() + "/login?signupsuccess=true");
		return;
	}

}
