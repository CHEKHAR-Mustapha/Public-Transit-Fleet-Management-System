package businesslayer;

/**
 * Strategy for formatting TimeTrack reports.
 * @authors:
 * 1- Mustapha Chekhar
 * 2- Anas Eddaoualline 
 * 3- Dan Han 
 * 4- Irshad Noori 
 */
public class TimeTrackReportStrategy implements ReportStrategy {
    /**
     * Formats the TimeTrack report data.
     * @param data the raw data
     * @return the formatted data
     */
    @Override
    public String formatData(String data) {
        return "TimeTrack Report: " + data; 
    }
}