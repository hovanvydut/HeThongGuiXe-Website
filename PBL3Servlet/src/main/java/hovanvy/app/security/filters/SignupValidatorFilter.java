package hovanvy.app.security.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static hovanvy.common.validator.CustomerValidator.*;

import hovanvy.common.enums.MessageEnum;
import hovanvy.common.enums.PathJsp;
import hovanvy.common.validator.CustomerValidator;
import hovanvy.entity.Customer;


/**
 * 
 * @author hovanvydut
 *
 */

@WebFilter(urlPatterns = {"/sign-up"})
public class SignupValidatorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest reqServlet, ServletResponse resServlet, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) reqServlet;
		HttpServletResponse response = (HttpServletResponse) resServlet;
		
		// only apply this filter for POST method
		if (request.getMethod().equals("POST")) {
			// validate data here
			request.setCharacterEncoding("UTF-8");
			
			Customer customer = parseCustomerFrom(request);
			System.out.println(customer);
			CustomerValidator validator = isFullnameValid()
											.and(isUsernameValid())
											.and(isPasswordValid());
			
			if (customer.getEmail() != null) {
				validator = validator.and(isEmailValid());
			}
			
			if (customer.getPhone() != null) {
				validator = validator.and(isPhoneValid());
			}
			
			CustomerValidationResult result = validator.apply(customer);
			
			if (result == CustomerValidationResult.SUCCESS) {
				// if data is valid, then execute SignupServlet
				request.setAttribute("customer", customer);
				chain.doFilter(request, response);
				return;
			} else {
				System.out.println(result);
				// if data is not valid ==> show error in signup page
				request.setAttribute("errorMessage", MessageEnum.DATA_INVALID.get());
				request.getRequestDispatcher(PathJsp.SIGN_UP.getPath()).forward(request, response);
				return;
			}
		} else {
			// For GET, PUT, ... (exclude POST method) running
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}
	
	private Customer parseCustomerFrom(HttpServletRequest request) {
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String studentId = request.getParameter("studentId");
		
		Customer customer = new Customer();
		customer.setFullname(fullname);
		customer.setUsername(username);
		customer.setStudent_id(studentId);
		
		if (email == null || email.equals("")) {
			customer.setEmail(null);
		} else {
			customer.setEmail(email);
		}
		
		if (phone == null || phone.equals("")) {
			customer.setPhone(null);
		} else {
			customer.setPhone(phone);
		}
		;
		customer.setPassword(password);
		customer.setCard_id(null);
		
		return customer;
	}

}
