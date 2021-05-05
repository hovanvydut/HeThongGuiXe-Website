package hovanvy.app.customers.controllers;

import hovanvy.app.customers.services.CustomerService;
import hovanvy.app.customers.services.CustomerServiceImpl;
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

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/customers/info"})
public class CustomerInfoServlet extends HttpServlet{
    
    private final String customerInfoJsp = "/templates/pages/customers/customer_info.jsp";
    private CustomerService customerService = new CustomerServiceImpl();
    
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
        
        
        RequestDispatcher rd = request.getRequestDispatcher(customerInfoJsp);
        
        rd.forward(request, response);
    }
}
