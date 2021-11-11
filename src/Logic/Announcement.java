package Logic;

import Data.Database;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An announcement in the database (not all properties are included)
 * @author Travis Tran & Jesus Sandoval & Tessa Henson
 * @version 2020.12.02
 * JS: Updated Authors
 * JS: Added # of subscribers field
 * JS: Added getter for subscribers
 * JS: Added subscribers to constructor
 * TH: Added try catch blocks
 * TH: re-did the returnAnnouncmeentRows method
 * TH: removed returnAnnouncementRows as it wasn't being used for version 2020.12.02
 */
public class Announcement {
    private String date;
    private String sender;

    //Using these variables instead
    private String message;
    private int userID;
    private int sentTo;
    private String dateCreated;
    private String subject;

    private String aFromDate;
    private String aToDate;

    private static String SQL_FIND_NOTIFICATIONS = "SELECT * FROM MS_Notification WHERE DateCreated >= ? AND DateCreated <= ?;";

    public Announcement(String dateCreated, int userID, int sentTo, String subject, String message) {
        this.dateCreated = dateCreated;
        this.userID = userID;
        this.sentTo = sentTo;
        this.subject = subject;
        this.message = message;
    }

    /**
     * Default constructor
     */
    public Announcement() {

    }

    /**
     * dataArr() provides data after running an sql query
     * @return array with a hashmap of all the data from the sql query statement
     */
    public ArrayList<HashMap<String, String>> dataArr() {
        try {
            ArrayList<HashMap<String, String>> allRows = Database.runQuery(SQL_FIND_NOTIFICATIONS,
                    new String[] {getFromDate(), getToDate()});

            //ArrayList<HashMap<String, String>> allRows = Data.AnnouncementData.findAnnouncements();
            System.out.println("Query ran successfully");
            return allRows;
        } catch (Exception e) {
            System.out.println("Error, exception found: " + e);
            return null;
        }
    }

    /**
     * @return subject from message
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return message text
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter for lower date range
     * @param sFrom is the lower date range
     */
    public void setFromDate(String sFrom) { aFromDate = sFrom; }

    /**
     * Setter for upper date range
     * @param sTo is the upper date range
     */
    public void setToDate(String sTo) { aToDate = sTo; }

    /**
     * Accessor for lower date range
     * @return lower date range
     */
    public String getFromDate() { return aFromDate; }

    /**
     * Accessor for upper date range
     * @return upper date range
     */
    public String getToDate() { return aToDate; }
}


