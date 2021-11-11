package Logic;

import java.util.regex.PatternSyntaxException;

/**
 * Class AccountFieldValidation:
 * JF: + now allows empty phone numbers
 * @author Josh Farrell
 * @version 12/02/20
 */
public class AccountFieldValidation {
    /**
     * Checks that the provided string matches email format
     * @param email the string to be checked
     * @return true if the string matches email format and false otherwise
     */
    public static boolean checkEmailFormat(String email) {
        String emailRegex = "([a-zA-Z0-9\\.\\-_]+)(@)([a-zA-Z0-9\\-_]+)(\\.)([a-zA-Z]{2,})";
        boolean flag = false;
        try {
            if (email.matches(emailRegex)) {
                flag = true;
            }
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * Checks that the provided string matches phone number format
     * @param phone a string representing the number to be checked
     * @return true if the string matches phone format, false otherwise
     */
    public static boolean checkPhoneFormat(String phone) {
        String phoneRegex = new String("(\\d{10})");
        boolean flag = false;
        try {
            if (phone.matches(phoneRegex) || phone.isEmpty()) {
                flag = true;
            }
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
