package businesslayer;

/**
 * Strategy interface for energy efficiency calculations.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface EnergyStrategy {
    /**
     * Checks if energy usage is efficient.
     * @param amountUsed the amount used
     * @param distanceTraveled the distance traveled
     * @return true if efficient, false otherwise
     */
    boolean isEfficient(double amountUsed, double distanceTraveled);
}