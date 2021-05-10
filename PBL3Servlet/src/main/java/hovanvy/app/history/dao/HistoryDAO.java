package hovanvy.app.history.dao;

import hovanvy.entity.ParkingHistory;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface HistoryDAO {
    
    List<ParkingHistory> getAllHistory(Integer id);
    
}
