package businesslayer;

import dataaccesslayer.GPSTrackingDAO;
import dataaccesslayer.GPSTrackingDAOImpl;
import dataaccesslayer.OperatorLogDAO;
import dataaccesslayer.OperatorLogDAOImpl;
import Objects.GPSTracking;
import Objects.OperatorLog;
import transferobjects.CredentialsDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Business logic for tracking operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline
 * 3- Dan Han
 * 4- Irshad Noori
 */
public class TrackingBusinessLogic {
    private final GPSTrackingDAO gpsTrackingDAO;
    private final OperatorLogDAO operatorLogDAO;
    private final StationTrackingBusinessLogic stationTrackingLogic;

    /**
     * Constructor that initializes the DAOs.
     * @param creds the credentials to connect to the database
     * @throws SQLException if a database error occurs
     */
    public TrackingBusinessLogic(CredentialsDTO creds) throws SQLException {
        this.gpsTrackingDAO = new GPSTrackingDAOImpl(creds) {
            @Override
            public GPSTracking getGPSTrackingByOperatorId(int operatorId) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
        };
        this.operatorLogDAO = new OperatorLogDAOImpl(creds);
        this.stationTrackingLogic = new StationTrackingBusinessLogic(creds);
    }

    /** Gets all GPS tracking records. */
    public List<GPSTracking> getAllGPSTracking() throws SQLException {
        return gpsTrackingDAO.getAllGPSTracking();
    }

    /** Gets GPS tracking data for the vehicle assigned to a specific operator. */
    public GPSTracking getGPSTrackingByOperatorId(int operatorId) throws SQLException {
        return gpsTrackingDAO.getGPSTrackingByOperatorId(operatorId);
    }

    /** Gets logs for a specific operator (used to restrict Operator view). */
    public List<OperatorLog> getOperatorLogsById(int operatorId) throws SQLException {
        return operatorLogDAO.getOperatorLogsById(operatorId);
    }

    /** Adds a GPS record and triggers arrival/departure detection. */
    public void addGPSTracking(GPSTracking gps) throws SQLException {
        gpsTrackingDAO.addGPSTracking(gps);
        detectStationArrivalDeparture(gps);
    }

    /** Gets all operator logs (Manager view). */
    public List<OperatorLog> getAllOperatorLogs() throws SQLException {
        return operatorLogDAO.getAllOperatorLogs();
    }

    /** Adds a new operator log. */
    public void addOperatorLog(OperatorLog log) throws SQLException {
        operatorLogDAO.addOperatorLog(log);
    }

    /** Arrival/departure detection based on stationId changes. */
    private void detectStationArrivalDeparture(GPSTracking gps) throws SQLException {
        if (gps.getStationId() != null && !gps.getStationId().isEmpty()) {
            // arrival check
            List<GPSTracking> previous = gpsTrackingDAO.getRecentTrackingByVehicle(gps.getVehicleId(), 1);
            if (previous.isEmpty() ||
                !gps.getStationId().equals(previous.get(0).getStationId())) {
                stationTrackingLogic.recordArrival(gps.getVehicleId(), gps.getStationId());
            }
        } else {
            // departure check
            List<GPSTracking> previous = gpsTrackingDAO.getRecentTrackingByVehicle(gps.getVehicleId(), 1);
            if (!previous.isEmpty() &&
                previous.get(0).getStationId() != null &&
                !previous.get(0).getStationId().isEmpty()) {
                stationTrackingLogic.recordDeparture(gps.getVehicleId(), previous.get(0).getStationId());
            }
        }
    }

    /** Station report for one vehicle. */
    public List<Map<String, Object>> getVehicleStationReport(String vehicleId) throws SQLException {
        return stationTrackingLogic.getVehicleStationReport(vehicleId);
    }

    /** Station reports for all vehicles. */
    public Map<String, List<Map<String, Object>>> getAllVehicleStationReports() throws SQLException {
        return stationTrackingLogic.getAllVehicleStationReports();
    }}