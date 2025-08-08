package businesslayer;

/**
 * Strategy interface for report formatting.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public interface ReportStrategy {
    /**
     * Formats the report data.
     * @param data the raw data
     * @return the formatted data
     */
    String formatData(String data);
}