package hovanvy.app.history.services;

import hovanvy.app.history.dao.HistoryDAO;
import hovanvy.app.history.dao.HistoryDAOImpl;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingHistory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author hovanvydut
 */
public class HistoryServiceImpl implements HistoryService {
    
    private final HistoryDAO historyDAO;
    
    public HistoryServiceImpl() {
        this.historyDAO = new HistoryDAOImpl();
    }

    @Override
    public List<ParkingHistory> getAllHistory(Integer customerId) {
        return this.historyDAO.getAllHistory(customerId);
    }

    @Override
    public List<ParkingHistory> filterHistory(Integer customerId, String fromDateStr, String toDateStr) {
    	
        Customer customer = new Customer();
        customer.setID_customer(customerId);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-dd-MM");
        LocalDate fromLocalDate = LocalDate.parse(fromDateStr);
        LocalDate toLocalDate = LocalDate.parse(toDateStr);
        LocalDateTime fromDate = fromLocalDate.atStartOfDay();
        LocalDateTime toDate = toLocalDate.plusDays(1).atStartOfDay();
        
        return this.historyDAO.filterHistory(customer, fromDate, toDate);
    }
    
}
