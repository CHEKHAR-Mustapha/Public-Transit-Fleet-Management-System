package businesslayer;

/**
 * Strategy for formatting Consumption reports.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public class ConsumptionReportStrategy implements ReportStrategy {
    /**
     * Formats the Consumption report data.
     * @param data the raw data
     * @return the formatted data
     */
    @Override
    public String formatData(String data) {
        return "Consumption Report: " + data; 
    }
}