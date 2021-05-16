package hovanvy.core.history.services;

import hovanvy.entity.ParkingHistory;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface HistoryService {
    
    List<ParkingHistory> getAllHistory(Integer customerId);
    
    List<ParkingHistory> filterHistory(Integer customerId, String fromDateStr, String toDateStr);
}
