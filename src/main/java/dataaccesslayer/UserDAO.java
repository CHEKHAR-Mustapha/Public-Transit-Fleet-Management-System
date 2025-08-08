package dataaccesslayer;

import Objects.User;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface for user operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface UserDAO {
    List<User> getAllUsers() throws SQLException;
    User getUserById(int userId) throws SQLException;
    User getUserByEmail(String email) throws SQLException;
    void addUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int userId) throws SQLException;
}