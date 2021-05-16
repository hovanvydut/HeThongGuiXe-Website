package hovanvy.core.parking_package.services;

import hovanvy.common.exceptions.CustomerNotFoundException;
import hovanvy.common.exceptions.ParkingPackageNotFoundException;
import hovanvy.core.customers.dao.CustomerDAO;
import hovanvy.core.customers.dao.CustomerDAOImpl;
import hovanvy.core.parking_package.dao.ParkingPackageDAO;
import hovanvy.core.parking_package.dao.ParkingPackageDAOImpl;
import hovanvy.entity.Customer;
import hovanvy.entity.ParkingPackage;
import hovanvy.entity.Payment;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hovanvydut
 */

public class ParkingPackageServiceImpl implements ParkingPackageService {
    
    private ParkingPackageDAO parkingPackageDAO;
    private CustomerDAO customerDAO;
    
    public ParkingPackageServiceImpl() {
        this.parkingPackageDAO = new ParkingPackageDAOImpl();
        this.customerDAO = new CustomerDAOImpl();
    }
    
    @Override
    public List<ParkingPackage> findAllParkingPackages() {
        return this.parkingPackageDAO.getAllParkingPackages();
    }

    @Override
    public void createNewParkingPackage(ParkingPackage parkingPackage) {
        this.parkingPackageDAO.save(parkingPackage);
    }

    @Override
    public Payment register(Integer customerId, Integer parkingPackageId) 
                throws CustomerNotFoundException, ParkingPackageNotFoundException{
        Optional<Customer> customerOpt = this.customerDAO.findById(customerId);
        Optional<ParkingPackage> parkingPackageOpt = this.parkingPackageDAO.findById(parkingPackageId);
       
        if (customerOpt.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        
        if (parkingPackageOpt.isEmpty()) {
            throw new ParkingPackageNotFoundException();
        }
        
        return this.parkingPackageDAO.register(customerOpt.get(), parkingPackageOpt.get());
    }
    
}
