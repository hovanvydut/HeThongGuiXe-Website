package hovanvy.core.parking_package.services;

import hovanvy.common.exceptions.CustomerNotFoundException;
import hovanvy.common.exceptions.ParkingPackageNotFoundException;
import hovanvy.entity.ParkingPackage;
import hovanvy.entity.Payment;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public interface ParkingPackageService {
    
    List<ParkingPackage> findAllParkingPackages();
    
    void createNewParkingPackage(ParkingPackage parkingPackage);
    
    Payment register(Integer customerId, Integer parkingPackageId) 
            throws CustomerNotFoundException, ParkingPackageNotFoundException;
}
