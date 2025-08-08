package dataaccesslayer;

import Objects.Vehicle;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for vehicle operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface VehicleDAO {
    List<Vehicle> getAllVehicles() throws SQLException;
    Vehicle getVehicleById(String vehicleId) throws SQLException;
    void addVehicle(Vehicle vehicle) throws SQLException;
    void updateVehicle(Vehicle vehicle) throws SQLException;
    void deleteVehicle(String vehicleId) throws SQLException;
}