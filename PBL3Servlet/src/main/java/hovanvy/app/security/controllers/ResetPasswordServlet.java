package hovanvy.app.security.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.app.customers.services.CustomerDetailsService;
import hovanvy.app.customers.services.CustomerDetailsServiceImpl;
import hovanvy.common.enums.MessageEnum;
import hovanvy.common.enums.PathJsp;
import hovanvy.common.userdetails.UserDetails;
import hovanvy.entity.Customer;
import hovanvy.util.CustomerUtil;
import hovanvy.util.PasswordEncoder;

/**
 * 
 * @author hovanvydut
 *
 */

// -- (req, res) --> ResetPasswordValidatorFilter --- (req, res) --> ResetPasswordServlet
@WebServlet(urlPatterns = {"/customers/reset-password"})
public class ResetPasswordServlet extends HttpServlet{
	
	private final CustomerDetailsService customerService = new CustomerDetailsServiceImpl();
	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher(PathJsp.RESET_PASSWORD.getPath()).forward(request, response);
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// see ResetPasswordValidatorFilter
		
		String oldPassword = request.getParameter("oldPassword");
		String password = request.getParameter("password");
		
		Customer loggedInUser = CustomerUtil.getLoggedInUser(request);
		
		if (PasswordEncoder.encode(oldPassword).equals(loggedInUser.getPassword())) {
			// change password
			loggedInUser.setPassword(PasswordEncoder.encode(password));
			this.customerService.update(loggedInUser);
			
			response.sendRedirect(request.getContextPath() + "/customers/info");
			return;
		} else {
			request.setAttribute("errorMessage", MessageEnum.OLD_PASSWORD_NOT_MATCH.get());
			request.getRequestDispatcher(PathJsp.RESET_PASSWORD.getPath()).forward(request, response);
			
			return;
		}
	}

}
