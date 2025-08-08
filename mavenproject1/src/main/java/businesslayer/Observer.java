package businesslayer;

/**
 * Observer interface for alert notifications.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface Observer {
    /**
     * Updates the observer when an alert is added.
     */
    void update();
}