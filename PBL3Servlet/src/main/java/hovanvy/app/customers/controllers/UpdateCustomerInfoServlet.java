package hovanvy.app.customers.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.app.customers.services.CustomerDetailsService;
import hovanvy.app.customers.services.CustomerDetailsServiceImpl;
import hovanvy.entity.Customer;
import hovanvy.util.CustomerUtil;

/**
 * 
 * @author hovanvydut
 *
 */

@WebServlet(urlPatterns = {"/customers/update"})
public class UpdateCustomerInfoServlet extends HttpServlet{
	
	private CustomerDetailsService customerService = new CustomerDetailsServiceImpl();
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		Customer loggedInCustomer = CustomerUtil.getLoggedInUser(request);
		
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		if ((email != null) && email.isBlank()) {
			email = null;
		}
		
		if ((phone != null) && phone.isBlank()) {
			phone = null;
		}
		
		if (fullname == null || fullname.isBlank()) {
			fullname = loggedInCustomer.getFullname();
		}
		
		loggedInCustomer.setFullname(fullname);
		loggedInCustomer.setEmail(email);
		loggedInCustomer.setPhone(phone);
		
		System.out.println("**** " + fullname + " " + email + " " + phone);
		this.customerService.update(loggedInCustomer);
		
		response.sendRedirect(request.getContextPath() + "/customers/info");
	}
	
}
