package Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Notifications log query stuff
 * @author Tessa Henson
 * @version 2020.12.01
 *
 */

public class AnnouncementData {

    private String aDate;
    private int aSenderID;
    private int aSentTo;
    private String aSubject;
    private String aMessage;

    private String aFromDate;
    private String aToDate;

    private static String SQL_FIND_NOTIFICATIONS = "SELECT * FROM MS_Notification WHERE DateCreated >= ? AND DateCreated <= ?;";

    /**
     * Finds data from provided query
     * @return array of hashmaps with data from query
     */
    public  ArrayList<HashMap<String, String>> findAnnouncements() { //String fromDate, String toDate) {
        try {
            return Database.runQuery(SQL_FIND_NOTIFICATIONS, new String[] {getFromDate(), getToDate()});
        } catch (Exception e) {
            System.out.println("Notifications couldn't be found. Error: " + e);
            return null;
        }
    }

    public void setFromDate(String sFrom) { aFromDate = sFrom; }

    public void setToDate(String sTo) { aToDate = sTo; }

    public String getFromDate() { return aFromDate; }

    public String getToDate() { return aToDate; }

}
