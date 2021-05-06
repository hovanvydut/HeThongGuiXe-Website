package hovanvy.app.customers.controllers;

import hovanvy.app.customers.services.CustomerDetailsServiceImpl;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hovanvy.app.customers.services.CustomerDetailsService;
import hovanvy.common.enums.PathJsp;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/customers/info"})
public class CustomerInfoServlet extends HttpServlet{
    
    private CustomerDetailsService customerService = new CustomerDetailsServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Customer> customers = this.customerService.getAllCustomers();
        
        for (Customer customer : customers) {
            System.out.println(customer);
            for (ParkingHistory history : customer.getParkingHistorys()) {
                System.out.println(history);
            }
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher(PathJsp.CUSTOMER_INFO.getPath());
        
        rd.forward(request, response);
    }
}
