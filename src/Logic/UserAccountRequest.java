package Logic;

import org.mindrot.jbcrypt.BCrypt;
/**
 * Class UserAccountRequest
 * A class abstracting login credentials
 * Handles username and password given by a login or account creation request
 * To be extended as needed
 * JF: + constructor
 * JF: + username with accessors and mutators
 * JF: + password with accessors and mutators
 * JF: + setting password now converts provided string to a hash
 * JF: + password param for constructor now accepts char[] as do its related methods
 * JF: + javadoc
 * JF: + added temporary field password and refactored to use it primarily while waiting for encryption
 * JF: + added password hashing with bcrypt
 * @author JOSH FARRELL
 * @version 11/11/20
 */
public class UserAccountRequest {
    private String username;
    private String password;
    private Boolean validated = false;

    public UserAccountRequest(String username, char[] password) {
        setUsername(username);
        setPassword(charToString(password));
    }

    /**
     * Ensures validity of fields
     * @throws Exception if fields are empty
     */
    protected void inputValidation() throws Exception{
        if (username.equals("") || password.equals("")) {
            throw new Exception("Please fill out all fields");
        }
    }

    /**
     * Returns a summary of the fields for this object
     * @return A list of the fields in this object and their values
     */
    public String getRequestDetails() {
        return "Username: " + username + "\nPassword Hash: " + password;
    }

    /**
     * Accepts a String and hashes it using bcrypt with a randomly generated salt
     * @param plainText The text to be hashed
     * @return The hashcode
     */
    protected String createHash(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt(12));
    }

    /**
     * Maps a char array to a String
     * @param chars the char array to be converted
     * @return the resulting String
     */
    public String charToString(char[] chars) {
        String string = new String();
        for (char character : chars) {
            string += character;
        }
        return string;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValidated (){
        return validated;
    }

    protected void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }
}
