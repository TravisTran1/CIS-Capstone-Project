package Logic;

import Data.AccountQueryHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Static class AccountEditsHandler
 * Handles all functions related to updating an account
 * @author Josh Farrell
 * @version 12/02/20
 */
public class AccountEditsHandler {

    /**
     * accepts an AccountEditsForm and replaces the notification related fields in the database with the fields in the form
     * @param form an AccountEditsForm with a new email, phone and whether or not to receive notifications for those methods as well as the uid for the associated user
     * @throws Exception if any of the fields are invalid or if a database error occurs
     */
    public static void editNotifications(AccountEditsForm form) throws Exception {
        form.validate();
        AccountQueryHandler.updateNotifications(form);
    }

    /**
     * Calls the queryhandler to retrieve fields related to notifications for the related user
     * @param uid the user id of the user to fetch
     * @return a Hashmap with the email, phone, sendEmail and sendSMS fields
     * @throws Exception if something goes wrong in the data layer
     */
    public static HashMap<String, String> getNotificationSettings(String uid) throws Exception {
        return AccountQueryHandler.getNotificationSettings(uid).get(0);
    }

}
