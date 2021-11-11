package Presentation;

/**
 * An interface for classes to be notified of logins
 * @author Josh Farrell
 * @version 11/11/2020
 */
public interface LoginListener {
    void login(String UID, String Admin);
}
