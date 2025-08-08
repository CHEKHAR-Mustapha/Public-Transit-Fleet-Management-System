package dataaccesslayer;

import Objects.Report;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for report operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface ReportDAO {
    List<Report> getAllReports() throws SQLException;
    void addReport(Report report) throws SQLException;
}