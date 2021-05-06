package hovanvy.app.security.filters;

import hovanvy.common.userdetails.UserDetails;
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

/**
 *
 * @author hovanvydut
 */

@WebFilter(urlPatterns = {"/home/*", "/package-list/*", "/customers/*", "/history/*"})
public class SecurityFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest reqServlet, ServletResponse resServlet, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) reqServlet;
        HttpServletResponse response = (HttpServletResponse) resServlet;
        
        UserDetails loggedInUser = (UserDetails) request.getSession().getAttribute("loggedInUser");
        
        // get full URL to redirecting back a page after login successfully
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String fullUrl = (queryString != null) ? (uri + "?" + queryString) : (uri);
        
        // if user has not logged in, redirect to Login Page
        if (loggedInUser == null) {
            response.sendRedirect(request.getContextPath() + "/login?from=" + fullUrl);
            return;
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
    
}
