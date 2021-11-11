package Logic;

import Data.Database;
import Data.MessageQueryHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Travis Tran
 * @version 2020.11.29
 * Allows the Message GUI to write to the database
 * Temporarily converts Usernames to Foreign Key
 *
 * TT: added method to convert username to Foreign Key
 * TT: added getDate method
 * TT: now logs messages to the MS_Notification table
 * TT: added method to check if username is from an admin account
 * TT: added exception handling for new database changes
 * TT: no longer uses senderTextField to get userID
 * TT: removed select statement from SQL_QUERY_LOG_Message
 * TT: removed method to get foreign key from username
 * TT: removed method to check if username is an admin
 * TT: moved SQL queries to query handler
 */

public class MessageLogging {
    MessageQueryHandler query = new MessageQueryHandler();

    public MessageLogging(){
    }

    /**
     * Takes in message data and logs message in the MS_Notification table
     * @param subject
     * @param body
     * @param foreignKey
     * @param date
     */
    public void logMessage(String subject, String body, int foreignKey, String date) {
        String userID = Integer.toString(foreignKey);
        try {
            Database.runQuery(query.getLogQuery(), new String[] {userID, date, subject, body});
        } catch (Exception e) {}
    }

    /**
     * Return the current date
     * @return date
     */
    public String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        return currentDate;
    }
}
