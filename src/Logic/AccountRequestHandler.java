package Logic;

import Data.AccountQueryHandler;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class AccountRequestHandler:
 * Login and account creation handler for the logic layer
 * Builds the request wrapper and passes it to Data
 * JF: + request field with accessors and mutators
 * JF: + methods to open requests for logins and account creation
 * JF: + javadoc
 * JF: + interfaced with AccountQueryHandler in openLoginRequest()
 * @author Josh Farrell
 * @version 11/11/20
 */
public class AccountRequestHandler {

    /**
     * Creates a new account request and passes it to the Data layer
     * @param username The username for the new account
     * @param name The name of the new account holder
     * @param email The email of the new account holder
     * @param password The password for the new account
     * @param passwordVerification A repeat of password to ensure it was properly entered
     * @return The result set
     */
    public ArrayList<HashMap<String, String>> openNewAccountRequest(String username, String name, String email, char[] password, char[] passwordVerification) throws Exception{
        AccountCreationRequest request = new AccountCreationRequest(username, password, passwordVerification, name, email);
        //ensure an account does not already exist with these credentials
        if (AccountQueryHandler.checkForAccount(username, email)) {
            throw new Exception("An account with that username or email already exists");
        }
        ArrayList<HashMap<String, String>> results = AccountQueryHandler.runWriteQuery(request);
        return results;
    }

    /**
     * Creates a login request and passes it to the Data layer
     * @param password The password for the account to be accessed
     * @param username The username for the account to be accessed
     * @return The result set of the found user or null if none was found
     */
    public ArrayList<HashMap<String, String>> openLoginRequest(char[] password, String username) throws Exception{
        LoginRequest request = new LoginRequest(username, password);
        ArrayList<HashMap<String, String>> results = AccountQueryHandler.runAccessQuery(request);
        //validate
        if (results.size() > 1) {
            throw new Exception("Database exception: More than one " + username + " was found");
        }
        if (results.size() < 1) {
            throw new Exception("Incorrect Credentials");
        }
        request.checkHash(results.get(0).get("Password"));
        return results;
    }
}
