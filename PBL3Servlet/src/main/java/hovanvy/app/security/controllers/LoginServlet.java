package hovanvy.app.security.controllers;

import hovanvy.app.customers.services.CustomerDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hovanvy.app.customers.services.CustomerDetailsService;
import hovanvy.app.security.customeruserdetails.CustomerUserDetails;
import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.common.userdetails.UserDetails;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/login"}, name = "LoginServlet")
public class LoginServlet extends HttpServlet{
    
    private static final String LOGIN_JSP = "/templates/pages/login/login.jsp";
    
    private final CustomerDetailsService customerService = new CustomerDetailsServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // validate username, password here
        
        try {
            
            UserDetails userInDB = this.customerService.loadUserByUsername(username);
            
            if (!userInDB.getPassword().equals(password)) {
                throw new UsernameNotFoundException("Username or Password is wrong");
            }
            
            request.getSession().setAttribute("loggedInUser", userInDB);
            response.sendRedirect(request.getContextPath() + "/home");
            
            return;
        } catch (UsernameNotFoundException ex) {
            
            // show error "username or password wrong" in login.jsp page
            String msg = "Username or Password is wrong";
            
            request.setAttribute("errorMessage", msg);
            request.setAttribute("username", username);
            
            request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
            
            return;
        }
    }
}
