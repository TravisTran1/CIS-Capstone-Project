package Data;

import Logic.AccountCreationRequest;
import Logic.AccountEditsForm;
import Logic.LoginRequest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AccountQueryHandlerTest {

    @Test
    void checkForRealAccount() {
        boolean exists = false;
        try {
            exists = AccountQueryHandler.checkForAccount("TheDandelionKnight", "jean@knightsfavonius.gov");
        } catch (Exception e) {
            System.out.println("Database Error");
            e.printStackTrace();
        }
        assertTrue(exists);
    }

    @Test
    void checkForFakeAccount() {
        boolean exists = true;
        try {
            exists = AccountQueryHandler.checkForAccount("NotTheDandelionKnight", "notjean@knightsfavonius.gov");
        } catch (Exception e) {
            System.out.println("Database Error");
            e.printStackTrace();
        }
        assertFalse(exists);
    }

    @Test
    void checkForFakeEmailAccount() {
        boolean exists = false;
        try {
            exists = AccountQueryHandler.checkForAccount("TheDandelionKnight", "notjean@knightsfavonius.gov");
        } catch (Exception e) {
            System.out.println("Database Error");
            e.printStackTrace();
        }
        assertTrue(exists);
    }

    @Test
    void checkForFakeUnameAccount() {
        boolean exists = false;
        try {
            exists = AccountQueryHandler.checkForAccount("NotTheDandelionKnight", "jean@knightsfavonius.gov");
        } catch (Exception e) {
            System.out.println("Database Error");
            e.printStackTrace();
        }
        assertTrue(exists);
    }

    @Test
    void runAccessQuery() {
        LoginRequest request;
        ArrayList<HashMap<String, String>> results = new ArrayList<HashMap<String, String>>();
        try {
            request = new LoginRequest("TheDandelionKnight", new char[] {'b','a','r','b','a','t','o','s'});
            results = AccountQueryHandler.runAccessQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(results.get(0).get("Username"), "TheDandelionKnight");
        assertEquals(results.get(0).get("FullName"), "Jean");
        assertEquals(results.get(0).get("Email"), "jean@knightsfavonius.gov");
    }

    @Test
    void updateCheck() {
        LoginRequest request;
        ArrayList<HashMap<String, String>> results = new ArrayList<HashMap<String, String>>();
        try {
            request = new LoginRequest("TheDandelionKnight", new char[] {'b','a','r','b','a','t','o','s'});
            //get uid
            results = AccountQueryHandler.runAccessQuery(request);
            //change fields
            AccountQueryHandler.updateNotifications(new AccountEditsForm(Integer.parseInt(results.get(0).get("UserID")),"New@email.test", "4444444444", 0, 0));
            //get new fields
            results = AccountQueryHandler.runAccessQuery(request);
            //test new values
            assertEquals(results.get(0).get("Email"), "New@email.test");
            assertEquals(results.get(0).get("Phone"), "4444444444");
            assertEquals(results.get(0).get("SendEmail"), "0");
            assertEquals(results.get(0).get("SendSMS"), "0");
            //return fields to normal
            AccountQueryHandler.updateNotifications(new AccountEditsForm(Integer.parseInt(results.get(0).get("UserID")), "jean@knightsfavonius.gov", "5555555555", 1, 1));
            results = AccountQueryHandler.runAccessQuery(request);
            //assert
            assertEquals(results.get(0).get("Email"), "jean@knightsfavonius.gov");
            assertEquals(results.get(0).get("Phone"), "5555555555");
            assertEquals(results.get(0).get("SendEmail"), "1");
            assertEquals(results.get(0).get("SendSMS"), "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}