package dataaccesslayer;

import Objects.StationEvent;
import java.sql.SQLException;
import java.util.List;

/**
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface StationEventDAO {
    List<StationEvent> getAllStationEvents() throws SQLException;
    List<StationEvent> getStationEventsByVehicle(String vehicleId) throws SQLException;
    List<StationEvent> getStationEventsByStation(String stationId) throws SQLException;
    void addStationEvent(StationEvent event) throws SQLException;
}