package hovanvy.app.parking_package.services;

import hovanvy.entity.ParkingPackage;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface ParkingPackageService {
    
    List<ParkingPackage> findAllParkingPackages();
    
    void saveParkingPackage(ParkingPackage parkingPackage);
    
}
