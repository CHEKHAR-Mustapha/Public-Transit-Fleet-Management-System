package dataaccesslayer;

import Objects.MaintenanceTask;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for maintenance task operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface MaintenanceTaskDAO {
    List<MaintenanceTask> getAllMaintenanceTasks() throws SQLException;
    void addMaintenanceTask(MaintenanceTask task) throws SQLException;
    void updateMaintenanceTask(MaintenanceTask task) throws SQLException;
    void deleteMaintenanceTask(int taskId) throws SQLException;
}