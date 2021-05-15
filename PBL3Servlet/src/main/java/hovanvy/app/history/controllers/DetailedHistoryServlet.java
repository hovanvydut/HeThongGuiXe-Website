package hovanvy.app.history.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.app.history.services.HistoryService;
import hovanvy.app.history.services.HistoryServiceImpl;
import hovanvy.common.enums.PathJsp;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import hovanvy.util.CustomerUtil;

/**
 *
 * @author hovanvydut
 */

/**
 * 
 * @see HistoryValidationFilter helps validate request params
 *
 */
@WebServlet(urlPatterns = {"/history/details"}, name = "DetailedHistoryServlet")
public class DetailedHistoryServlet extends HttpServlet {
    
    private final HistoryService historyService = new HistoryServiceImpl();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String fromDate = parseStringDate(request, "fromDate");
        String toDate = parseStringDate(request, "toDate");
        
        Customer loggedInCustomer = CustomerUtil.getLoggedInUser(request);
        
        List<ParkingHistory> history = 
                this.historyService.filterHistory(loggedInCustomer.getID_customer(), fromDate, toDate);

        request.setAttribute("history", history);
        request.setAttribute("toDate", toDate);
        request.setAttribute("fromDate", fromDate);
        
        RequestDispatcher dp = request.getRequestDispatcher(PathJsp.DETAILED_HISTORY.getPath());
        dp.forward(request, response);
    }
    
    private static String parseStringDate(HttpServletRequest request, String parameter) {
    	String date = (String) request.getParameter(parameter);
    	
    	if (date == null) {
        	date = LocalDate.now().toString();
        }
    	
    	return date;
    }
}