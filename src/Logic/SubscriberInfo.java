package Logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Travis Tran
 * @version 2020.11.29
 * Retrieve Emails of subscribers on the database
 *
 * TT: added constructor for Email
 * TT: added method to get ArrayList from database
 * TT: created query to get Emails of subscribers
 * TT: added method to count number of emails in the list
 * TT: switched to new Database interface
 * TT: added method to get a String of subscriber emails to send to
 * TT: removed method to count subscriber emails in favor of doing it through SQL
 * TT: added method to get a list of phone numbers
 * TT: moved SQL queries to query handler
 */

public class SubscriberInfo {

    public SubscriberInfo(){
    }

    /**
     * get a String of subscriber emails
     * @param queryResults list of subscriber emails
     * @return emails String of subscriber emails for message to be sent to
     */
    public String getEmailsString(ArrayList<HashMap<String, String>> queryResults) {
        String emails = "";
        for (HashMap<String, String> map : queryResults){
            emails = emails + map.get("Email") + ", ";
        }
        return emails;
    }

    public ArrayList<String> getPhoneNumberList(ArrayList<HashMap<String, String>> queryResults){
        ArrayList<String> phoneNumbers = new ArrayList<String>();
        for (HashMap<String, String> map : queryResults){
            phoneNumbers.add(map.get("Phone"));
        }
        return phoneNumbers;
    }
}
