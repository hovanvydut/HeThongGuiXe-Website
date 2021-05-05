package hovanvy.app.customers.controllers;

import java.io.IOError;
import java.io.IOException;
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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher(customerInfoJsp);
        
        rd.forward(request, response);
    }
}
