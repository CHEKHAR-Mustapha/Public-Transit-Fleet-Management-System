package dataaccesslayer;

import Objects.OperatorLog;
import transferobjects.CredentialsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implementation for operator log operations.
 * Table assumed: operator_logs(
 *   log_id INT PK, vehicle_id VARCHAR, start_time DATETIME, end_time DATETIME,
 *   event_type VARCHAR, operator_id INT
 * )
 *  @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public class OperatorLogDAOImpl implements OperatorLogDAO {
    private final Connection connection;

    public OperatorLogDAOImpl(CredentialsDTO creds) throws SQLException {
        DataSource dataSource = DataSource.getInstance(creds);
        this.connection = dataSource.getConnection();
    }

    @Override
    public List<OperatorLog> getAllOperatorLogs() throws SQLException {
        String sql = "SELECT * FROM operator_logs ORDER BY start_time DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return mapLogs(rs);
        }
    }

    @Override
    public List<OperatorLog> getOperatorLogsById(int operatorId) throws SQLException {
        String sql = "SELECT * FROM operator_logs WHERE operator_id = ? ORDER BY start_time DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, operatorId);
            try (ResultSet rs = ps.executeQuery()) {
                return mapLogs(rs);
            }
        }
    }

    @Override
    public void addOperatorLog(OperatorLog log) throws SQLException {
        String sql = "INSERT INTO operator_logs (vehicle_id, start_time, end_time, event_type, operator_id) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, log.getVehicleId());
            ps.setString(2, log.getStartTime());
            ps.setString(3, log.getEndTime());
            ps.setString(4, log.getEventType());
            ps.setInt(5, log.getOperatorId());
            ps.executeUpdate();
        }
    }

    // ---- helpers ----
    private List<OperatorLog> mapLogs(ResultSet rs) throws SQLException {
        List<OperatorLog> logs = new ArrayList<>();
        while (rs.next()) {
            OperatorLog log = new OperatorLog();
            log.setLogId(rs.getInt("log_id"));
            log.setVehicleId(rs.getString("vehicle_id"));
            log.setStartTime(rs.getString("start_time")); 
            log.setEndTime(rs.getString("end_time"));
            log.setEventType(rs.getString("event_type"));
            log.setOperatorId(rs.getInt("operator_id"));
            logs.add(log);
        }
        return logs;
    }
}