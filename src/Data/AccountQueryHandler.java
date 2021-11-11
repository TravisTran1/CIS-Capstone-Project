package Data;

import Logic.AccountCreationRequest;
import Logic.AccountEditsForm;
import Logic.UserAccountRequest;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class AccountQueryHandler:
 * A static class that builds queries for accessing and writing account info to and from the database
 * @author Josh Farrell
 * @version 12/02/20
 * JF: + runAccessQuery implemented
 * JF: + runWriteQuery implemented
 * JF: + updateNotifications implemented
 * JF: + getNotificationSettings implemented
 */
public class AccountQueryHandler {
    private static final String checkIntegrityQuery = "SELECT Username, Email from MS_Users WHERE Username = ? OR Email = ?";
    private static final String accessAccountQuery = "SELECT UserID, SendEmail, SendSMS, Admin, Username, Email, Phone, FullName, Password FROM MS_Users WHERE Username = ?";
    private static final String writeAccountQuery = "INSERT INTO MS_Users (SendEmail, SendSMS, Admin, Username, Password, Email, Phone, FullName, DateLogin) VALUES (1, 0, 0, ?, ?, ?, NULL, ?, GETDATE())";
    public static final String updateEmailQuery = "Update MS_Users SET Email = ?, Phone = ?, SendEmail = ?, SendSMS = ? WHERE UserID = ?";
    public static final String getNotSettingsQuery = "SELECT Email, Phone, SendEmail, SendSMS FROM MS_Users WHERE UserID = ?";

    /**
     * Runs a query that inserts a record into the MS_Users table of the database using the provided request
     * @param request An AccountCreationRequest that contains the user data to be entered into the table
     * @return The results of the query
     */
    public static ArrayList<HashMap<String, String>> runWriteQuery(AccountCreationRequest request) throws Exception{
        String[] args = {request.getUsername(), BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()), request.getEmail(), request.getName()};
        Database.runQuery(writeAccountQuery, args);
        ArrayList<HashMap<String, String>> results = Database.runQuery(accessAccountQuery, new String[] {request.getUsername()});
        return results;
    }

    /**
     * checks if a record exists with either the provided username or email
     * @param username The username of the user to check for
     * @param email The email of the user to check for
     * @return true if there is an account with either the chosen username or email, false otherwise
     */
    public static boolean checkForAccount(String username, String email) throws Exception{
        ArrayList<HashMap<String, String>> results = Database.runQuery(checkIntegrityQuery, new String[] {username, email});
        if (results.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method runs a query looking for the account with the provided credentials and returns the results
     * @param request A UserAccountRequest with the credentials to be used in the query
     * @return The results of the query to be run
     */
    public static ArrayList<HashMap<String, String>> runAccessQuery(UserAccountRequest request) throws Exception{
        ArrayList<HashMap<String, String>> results = Database.runQuery(accessAccountQuery, new String[] {request.getUsername()});
        return results;
    }

    /**
     * Updates a user to match the details attached in the provided form
     * @param form an AccountEditsForm with the user id of the user to edit and the changes desired
     * @throws Exception if something goes wrong in the database
     */
    public static void updateNotifications(AccountEditsForm form) throws Exception{
        String[] args = {form.getEmail(), form.getPhone(), form.getEmailNotString(), form.getSmsNotString(), form.getUid()};
        Database.runQuery(updateEmailQuery, args);
    }

    /**
     * Retrieves all fields related to notifications for the provided user from the database
     * @param uid the user id of the user to retrieve data on
     * @return an Arraylist<Hashmap<String, String>> containing results
     * @throws Exception if something goes wrong in the database
     */
    public static ArrayList<HashMap<String, String>> getNotificationSettings(String uid) throws Exception {
        return Database.runQuery(getNotSettingsQuery, new String[] {uid});
    }
}
