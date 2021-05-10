package hovanvy.app.history.services;

import hovanvy.app.history.dao.HistoryDAO;
import hovanvy.app.history.dao.HistoryDAOImpl;
import hovanvy.entity.ParkingHistory;
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
    public List<ParkingHistory> getAllHistory(Integer userId) {
        System.out.println("-----> id = " + userId);
        return this.historyDAO.getAllHistory(userId);
    }
    
}
