package hovanvy.app.customers.controllers;

import hovanvy.app.customers.services.CustomerDetailsServiceImpl;
import hovanvy.app.payment.service.PaymentService;
import hovanvy.app.payment.service.PaymentServiceImpl;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import hovanvy.entity.Payment;

import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hovanvy.app.customers.services.CustomerDetailsService;
import hovanvy.common.enums.PathJsp;
import hovanvy.common.exceptions.CustomerNotFoundException;
import hovanvy.common.userdetails.UserDetails;
import hovanvy.util.CustomerUtil;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/customers/info"})
public class CustomerInfoServlet extends HttpServlet{
    
    private CustomerDetailsService customerService = new CustomerDetailsServiceImpl();
    private final PaymentService paymentService = new PaymentServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	Customer loggedInCustomer = CustomerUtil.getLoggedInUser(request);
    	
    	Optional<Payment> currentPaymentOpt = Optional.ofNullable(null);
		try {
			currentPaymentOpt = this.paymentService.getCurrentPayment(loggedInCustomer.getID_customer());
		} catch (CustomerNotFoundException e) {
			response.sendError(500);
			return;
		}
        
		
		if (currentPaymentOpt.isPresent()) {
			request.setAttribute("currentPayment", currentPaymentOpt.get());
		} else {
			request.setAttribute("currentPayment", null);
		}
        request.setAttribute("loggedInCustomer", loggedInCustomer);
        
        RequestDispatcher rd = request.getRequestDispatcher(PathJsp.CUSTOMER_INFO.getPath());
        
        rd.forward(request, response);
    }
}
