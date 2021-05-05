package hovanvy.app.parking_package.dao;

import hovanvy.entity.ParkingPackage;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface ParkingPackageDAO {
    
    List<ParkingPackage> getAllParkingPackages();
    
    void save(ParkingPackage parkingPackage);
    
}
