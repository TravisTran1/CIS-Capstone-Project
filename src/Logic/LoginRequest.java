package Logic;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Class LoginRequest
 * Extends UserAccountRequest
 * Abstracts login requests and wraps data
 * @author Josh Farrell
 * @version 11/10/20
 */
public class LoginRequest extends UserAccountRequest{
    public LoginRequest(String username, char[] password) throws Exception{
        super(username, password);
        inputValidation();
    }

    public void checkHash(String hash) throws Exception{
        if (BCrypt.checkpw(getPassword(), hash)){
            setValidated(true);
        } else {
            throw new Exception("Incorrect Credentials");
        }
    }
}
