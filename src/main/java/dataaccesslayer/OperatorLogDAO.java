package dataaccesslayer;

import Objects.OperatorLog;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for operator log operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline
 * 3- Dan Han
 * 4- Irshad Noori
 */
public interface OperatorLogDAO {
    List<OperatorLog> getAllOperatorLogs() throws SQLException;

    /** Fetch logs for a specific operator (used for Operator role view). */
    List<OperatorLog> getOperatorLogsById(int operatorId) throws SQLException;

    void addOperatorLog(OperatorLog log) throws SQLException;
}