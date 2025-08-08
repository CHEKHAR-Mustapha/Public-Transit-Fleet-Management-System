package dataaccesslayer;

import Objects.EnergyUsage;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for energy usage operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface EnergyUsageDAO {
    List<EnergyUsage> getAllEnergyUsage() throws SQLException;
    EnergyUsage getEnergyUsageById(int id) throws SQLException;
    List<EnergyUsage> getFilteredEnergyUsage(String fuelEnergyType, String startDate, String endDate) throws SQLException;
    void addEnergyUsage(EnergyUsage usage) throws SQLException;
    void updateEnergyUsage(EnergyUsage usage) throws SQLException;
    void deleteEnergyUsage(int id) throws SQLException;
}