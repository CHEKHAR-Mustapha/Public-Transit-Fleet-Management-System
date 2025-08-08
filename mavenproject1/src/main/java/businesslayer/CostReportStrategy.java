package businesslayer;

/**
 * Strategy for formatting Cost reports.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public class CostReportStrategy implements ReportStrategy {
    /**
     * Formats the Cost report data.
     * @param data the raw data
     * @return the formatted data
     */
    @Override
    public String formatData(String data) {
        return "Cost Report: " + data; 
    }
}