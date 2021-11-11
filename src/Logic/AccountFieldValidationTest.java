package Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountFieldValidationTest {
    @Test
    void checkValidEmail() {
        assertTrue(AccountFieldValidation.checkEmailFormat("valid-address@email.com"));
    }

    @Test
    void checkPrefixCharOutOfBounds() {
        String badEmail = "bad@email.com";
        String[] badChars = {".", "/", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "\'", "\"", ",", "\t", "\n", " ", "\\", "+", "=", "[", "]", "{", "}", "<", ">", "?"};
        for (String badChar : badChars){
            assertFalse(AccountFieldValidation.checkEmailFormat(badChar + badEmail));
        }
    }

    @Test
    void checkValidPhone() {
        assertTrue(AccountFieldValidation.checkPhoneFormat("5033396525"));
    }
}
