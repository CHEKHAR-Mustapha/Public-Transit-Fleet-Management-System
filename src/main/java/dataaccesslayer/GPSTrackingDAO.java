package dataaccesslayer;

import Objects.GPSTracking;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for GPS tracking operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface GPSTrackingDAO {
    List<GPSTracking> getAllGPSTracking() throws SQLException;
    List<GPSTracking> getRecentTrackingByVehicle(String vehicleId, int limit) throws SQLException;
    void addGPSTracking(GPSTracking gps) throws SQLException;

    public GPSTracking getGPSTrackingByOperatorId(int operatorId);
    
}