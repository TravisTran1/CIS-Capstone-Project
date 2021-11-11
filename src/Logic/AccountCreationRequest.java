package Logic;

/**
 * Class AccountCreationRequest:
 * An account creation request, wraps account information to be passed to the Data layer
 * JF: + name, passwordVerify and email fields and their accessors and mutators
 * JF: + getRequestDetails
 * JF: Changed constructor to accept char[] for passwords
 * JF: + javadoc
 * JF: + added password hashing with bcrypt
 * JF: + moved checkEmailFormat to AccountFieldValidation
 * @author JOSH FARRELL
 * @version 11/11/20
 */
public class AccountCreationRequest extends UserAccountRequest {
    private String name;
    private String passwordHash;
    private String passwordVerify;
    private String email;

    public AccountCreationRequest(String username, char[] password, char[] passwordVerify, String name, String email) throws Exception {
        super(username, password);
        setPasswordHash(createHash(getPassword()));
        setName(name);
        setPasswordVerify(charToString(passwordVerify));
        setEmail(email.toLowerCase());
        inputValidation();
    }

    /**
     * Ensures class data integrity
     * @throws Exception if input does not validate
     */
    @Override
    protected void inputValidation() throws Exception{
        if (getUsername().equals("") || getPassword().equals("") || name.equals("") || passwordVerify.equals("") || email.equals("")) {
            throw new Exception("Please fill out all fields");
        }
        if (!getPassword().equals(getPasswordVerify())) {
            throw new Exception("Passwords do not match");
        }
        if (!AccountFieldValidation.checkEmailFormat(getEmail())) {
            throw new Exception("The email you entered does not match email address form");
        }
    }

    /**
     * Returns a summary of the fields for this object
     * @return A list of the fields in this object and their values
     */
    @Override
    public String getRequestDetails() {
        return super.getRequestDetails() + "\nPassword Verification Hash: " + passwordVerify + "\nName: " + getName() + "\nEmail: " + getEmail();
    }

    public String getPasswordHash() { return passwordHash; }

    private void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
