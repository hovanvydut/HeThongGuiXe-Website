package hovanvy.app.history.services;

import hovanvy.entity.ParkingHistory;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface HistoryService {
    
    List<ParkingHistory> getAllHistory(Integer userId);
}
