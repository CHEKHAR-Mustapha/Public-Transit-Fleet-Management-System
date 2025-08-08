package dataaccesslayer;

import Objects.Component;
import java.sql.SQLException;
import java.util.List;

/**
 * Updated DAO interface for component operations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface ComponentDAO {
    List<Component> getAllComponents() throws SQLException;
    void addComponent(Component component) throws SQLException;
    void updateComponent(Component component) throws SQLException;
    Component getComponentById(int componentId) throws SQLException;
}