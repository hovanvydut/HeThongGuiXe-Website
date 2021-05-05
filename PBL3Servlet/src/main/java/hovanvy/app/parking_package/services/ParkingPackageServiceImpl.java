package hovanvy.app.parking_package.services;

import hovanvy.app.parking_package.dao.ParkingPackageDAO;
import hovanvy.app.parking_package.dao.ParkingPackageDAOImpl;
import hovanvy.entity.ParkingPackage;
import java.util.List;

/**
 *
 * @author hovanvydut
 */

public class ParkingPackageServiceImpl implements ParkingPackageService {
    
    private ParkingPackageDAO parkingPackageDAO;
    
    public ParkingPackageServiceImpl() {
        this.parkingPackageDAO = new ParkingPackageDAOImpl();
    }
    
    @Override
    public List<ParkingPackage> findAllParkingPackages() {
        return this.parkingPackageDAO.getAllParkingPackages();
    }

    @Override
    public void saveParkingPackage(ParkingPackage parkingPackage) {
        this.parkingPackageDAO.save(parkingPackage);
    }
    
}
