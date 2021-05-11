package hovanvy.app.parking_package.controllers;

import hovanvy.app.parking_package.services.ParkingPackageService;
import hovanvy.app.parking_package.services.ParkingPackageServiceImpl;
import hovanvy.common.enums.PathJsp;
import hovanvy.common.exceptions.CustomerNotFoundException;
import hovanvy.common.exceptions.ParkingPackageNotFoundException;
import hovanvy.entity.Customer;
import hovanvy.util.CustomerUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hovanvydut
 */

@WebServlet(urlPatterns = {"/parking-package/register"})
public class RegisterParkingPackageServlet extends HttpServlet{
    
    private final ParkingPackageService parkingPackageService = new ParkingPackageServiceImpl();
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                        throws IOException, ServletException {
        
        Customer loggedInUser = CustomerUtil.getLoggedInUser(request);
        Integer parkingPackageId = Integer.parseInt(request.getParameter("parkingPackageId"));
        
        try {
            this.parkingPackageService.register(loggedInUser.getID_customer(), parkingPackageId);
        } catch (CustomerNotFoundException | ParkingPackageNotFoundException ex) {
            Logger.getLogger(RegisterParkingPackageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect(request.getContextPath() + "/parking-package/list");
    }
    
}
