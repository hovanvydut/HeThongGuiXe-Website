package hovanvy.app.package_registration.controllers;

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

@WebServlet(urlPatterns = {"/package-list"}, name = "PackageListServlet")
public class PackageListServlet extends HttpServlet {
    
    private final String packageRegistrationJsp = "/templates/pages/package_registration/package_list.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        RequestDispatcher rd = 
                request.getRequestDispatcher(packageRegistrationJsp);
        
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
