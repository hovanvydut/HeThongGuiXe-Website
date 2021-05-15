package hovanvy.app.history.controllers;

import hovanvy.app.history.services.HistoryService;
import hovanvy.app.history.services.HistoryServiceImpl;
import hovanvy.common.enums.PathJsp;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import hovanvy.util.CustomerUtil;
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

@WebServlet(urlPatterns = {"/history"}, name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    
    private final HistoryService historyService = new HistoryServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Customer loggedInCustomer = CustomerUtil.getLoggedInUser(request);
        
        List<ParkingHistory> history = this.historyService.getAllHistory(loggedInCustomer.getID_customer());
        
        request.setAttribute("history", history);
        
        RequestDispatcher rd = request.getRequestDispatcher(PathJsp.HISTORY.getPath());
        rd.forward(request, response);
    }
    
}
