package hovanvy.app.customers.filter;

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
import static hovanvy.common.validator.CustomerValidator.CustomerValidationResult.*;

import hovanvy.common.enums.PathJsp;
import hovanvy.common.validator.CustomerValidator;
import hovanvy.entity.Customer;

/**
 * 
 * @author hovanvydut
 *
 */

@WebFilter(urlPatterns = {"/customers/update"})
public class UpdateCustomerValidatorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest reqServlet, ServletResponse resServlet, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) reqServlet;
		HttpServletResponse response = (HttpServletResponse) resServlet;
		
		request.setCharacterEncoding("UTF-8"); // !important for vietnamese character
		
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Customer customer = new Customer();
		customer.setFullname(fullname);
		customer.setEmail(email);
		customer.setPhone(phone);
		
		CustomerValidator validator = isFullnameValid();
		
		if (email != null && !email.isBlank()) {
			email = email.trim();
			validator = validator.and(isEmailValid());
		}
		
		if (phone != null && !phone.isBlank()) {
			phone = phone.trim();
			validator = validator.and(isPhoneValid());
		}

		
		CustomerValidationResult result = validator.apply(customer);
		
		if (result.equals(SUCCESS)) {
			chain.doFilter(request, response);
		} else {
			System.out.println("==> " + result);
			response.sendRedirect(request.getContextPath() + "/customers/info?error_update=true");
			return;
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
