package hovanvy.app.security.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.common.enums.PathJsp;
import hovanvy.common.validator.CustomerValidator;
import hovanvy.common.validator.CustomerValidator.CustomerValidationResult;
import static hovanvy.common.validator.CustomerValidator.CustomerValidationResult.*;
import hovanvy.entity.Customer;

public class ResetPasswordValidatorFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest reqServlet, ServletResponse resServlet, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) reqServlet;
        HttpServletResponse response = (HttpServletResponse) resServlet;
		
		String oldPassword = request.getParameter("oldPassword");
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		customer.setPassword(password);
		
		CustomerValidationResult result = CustomerValidator.isPasswordValid().apply(customer);
		
		if (oldPassword == null || password == null || !result.equals(SUCCESS)) {
			request.setAttribute("errorMessage", "Mat khau is not valid");
			request.getRequestDispatcher(PathJsp.RESET_PASSWORD.getPath()).forward(request, response);
			return;
		} else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
