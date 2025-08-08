package dataaccesslayer;

import Objects.Station;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for station operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface StationDAO {
    List<Station> getAllStations() throws SQLException;
    Station getStationById(String stationId) throws SQLException;
    List<Station> getStationsByRoute(String routeId) throws SQLException;
    void addStation(Station station) throws SQLException;
}