package hovanvy.app;

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

@WebServlet(urlPatterns = {"/home"}, name = "HomeServlet")
public class HomeServlet extends HttpServlet{
    
    private final String homeJsp = "/templates/pages/home/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dt = request.getRequestDispatcher(homeJsp);
        dt.forward(request, response);
    }
    
}
