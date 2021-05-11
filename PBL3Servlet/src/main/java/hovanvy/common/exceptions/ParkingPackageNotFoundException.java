package hovanvy.common.exceptions;

/**
 *
 * @author hovanvydut
 */

public class ParkingPackageNotFoundException extends Exception {
    
    public ParkingPackageNotFoundException() {
        super("ParkingPackage not found");
    }
    
    public ParkingPackageNotFoundException(String msg) {
        super(msg);
    }
    
    public ParkingPackageNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
