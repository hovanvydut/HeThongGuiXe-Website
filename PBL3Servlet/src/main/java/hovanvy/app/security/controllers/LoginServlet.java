package hovanvy.app.security.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.common.enums.MessageEnum;
import hovanvy.common.enums.PathJsp;
import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.common.userdetails.UserDetails;
import hovanvy.core.customers.services.CustomerDetailsService;
import hovanvy.core.customers.services.CustomerDetailsServiceImpl;
import hovanvy.entity.Customer;
import hovanvy.util.CustomerUtil;
import hovanvy.util.PasswordEncoder;
import hovanvy.util.URLUtil;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/login"}, name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private final CustomerDetailsService customerService = new CustomerDetailsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Customer customer = CustomerUtil.getLoggedInUser(request);
        
        // if has logged in, redirect to previous page
        if (customer != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        
        request.getRequestDispatcher(PathJsp.LOGIN.getPath()).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // url which request came from, then be redirected to login page. This will be used to redirect back to a page after login successfully
        String from = request.getParameter("from");
        from = processFromString(from);
        
        try {

            UserDetails userInDB = this.customerService.loadUserByUsername(username);
            
            // encode password
            password = PasswordEncoder.encode(password);

            if (!userInDB.getPassword().equals(password)) {
                throw new UsernameNotFoundException(MessageEnum.USERNAME_PASSWORD_WRONG.get());
            }
            
            // create new session
            request.getSession().setAttribute("loggedInUser", userInDB);
            
            // business relative to handle redirect url
            if (isValidFrom(from)) {
                response.sendRedirect(from);
            } else {
                response.sendRedirect(request.getContextPath() + "/home?loginSuccessfulMsg=true");
            }

            return;
        } catch (UsernameNotFoundException ex) {

            // show error "username or password wrong" in login.jsp page
            request.setAttribute("errorMessage", MessageEnum.USERNAME_PASSWORD_WRONG.get());
            request.setAttribute("username", username);
            request.setAttribute("from", from);

            request.getRequestDispatcher(PathJsp.LOGIN.getPath()).forward(request, response);

            return;
        }
    }
    
    private static boolean isValidFrom(String from) {
        return (from != null) && (!from.isBlank()) && (!from.contains("/login")) && (!from.contains("/logout"));
    }
    
    private static String processFromString(String from) {
        if ((from != null) && (!from.isBlank())) {
            if (from.contains("?")) {
                from += "&loginSuccessfulMsg=true";
            } else {
                from += "?loginSuccessfulMsg=true";
            }
        }
        
        return from;
    }
}
