package businesslayer;
import java.sql.SQLException;
/**
 * Command interface for maintenance tasks.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface Command {
    /**
     * Executes the command.
     * @throws SQLException if a database error occurs
     */
    void execute() throws SQLException;
}