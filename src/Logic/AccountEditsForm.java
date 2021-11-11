package Logic;

/**
 * Class AccountEditsForm
 * Wraps data involved in updating account settings
 * JF: + added extra validation
 * @author Josh Farrell
 * @version 12/02/20
 */
public class AccountEditsForm {
    private String uid;
    private String email;
    private String phone;
    private int emailNotifications;
    private int smsNotifications;

    public AccountEditsForm(int uid, String email, String phone, int emailNotifications, int smsNotifications) {
        this.uid = Integer.toString(uid);
        this.email = email;
        this.phone = phone;
        this.emailNotifications = emailNotifications;
        this.smsNotifications = smsNotifications;
    }

    /**
     * Input validation for the fields in this object
     * @throws Exception if one of the fields is invalid
     */
    public void validate() throws Exception{
        if (!AccountFieldValidation.checkPhoneFormat(phone)) {
            throw new Exception("Invalid Phone Number");
        } else if (!AccountFieldValidation.checkEmailFormat(email)) {
            throw new Exception("Invalid Email");
        }

        if (phone.isEmpty() && smsNotifications == 1) {
            throw new Exception("Cannot set sms notifications without a phone number");
        }

        if (email.isEmpty() && emailNotifications ==1) {
            throw new Exception("Cannot set email notifications without an email");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUid() {
        return uid;
    }

    public int getEmailNotifications() {
        return emailNotifications;
    }

    public String getEmailNotString() {
        return Integer.toString(emailNotifications);
    }

    public int getSmsNotifications() {
        return smsNotifications;
    }

    public String getSmsNotString() {
        return Integer.toString(smsNotifications);
    }
}
