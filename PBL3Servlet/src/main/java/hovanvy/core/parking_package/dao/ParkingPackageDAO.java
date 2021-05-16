package hovanvy.core.parking_package.dao;

import hovanvy.entity.Customer;
import hovanvy.entity.ParkingPackage;
import hovanvy.entity.Payment;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public interface ParkingPackageDAO {
    
    Optional<ParkingPackage> findById(Integer id);
    
    List<ParkingPackage> getAllParkingPackages();
    
    void save(ParkingPackage parkingPackage);
    
    Payment register(Customer customer, ParkingPackage parkingPackage);
    
}
