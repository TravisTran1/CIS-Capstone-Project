package Presentation;

import Logic.AccountRequestHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * GUI handling Login and account creation requests for end users
 * JF: + Added registerButton action listener
 * JF: + Added loginButton action listener
 * JF: + Added requestHandler
 * JF: + Connected button click action listeners to request handler interface
 * JF: + javadoc
 * JF: + login button now prints the UID of the associated user
 * JF: + Error Handling
 * JF: + Now confirms logins and account creation
 * JF: + implemented login event
 * JF: + connected to mainGUI
 * JF: + error handling now displays toString() instead of getMessage()
 * @author JOSH FARRELL
 * @version 12/02/20
 */
public class LoginGUI {
    private JPanel rootPanel;
    private JPasswordField createPasswordField;
    private JTextField emailField;
    private JButton registerButton;
    private JTextField createUsernameField;
    private JTextField nameField;
    private JPasswordField confirmPasswordField;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JButton logInButton;

    private AccountRequestHandler requestHandler;

    private List<LoginListener> listeners = new ArrayList<LoginListener>();

    public LoginGUI() {
        requestHandler = new AccountRequestHandler();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //write login info to database
                    HashMap<String, String> newAccount =  requestHandler.openNewAccountRequest(
                                                            createUsernameField.getText(),
                                                            nameField.getText(),
                                                            emailField.getText(),
                                                            createPasswordField.getPassword(),
                                                            confirmPasswordField.getPassword()
                                                          ).get(0);
                    //welcome user
                    JOptionPane.showMessageDialog(rootPanel, "Thank you for creating an account " + newAccount.get("Username"));
                    //then log in
                    login(newAccount.get("UserID"), newAccount.get("Admin"));
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(rootPanel, exc.toString());
                    clearTextBoxes();
                }
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //search for associated account
                    ArrayList<HashMap<String, String>> loginResults = requestHandler.openLoginRequest(loginPasswordField.getPassword(), loginUsernameField.getText());
                    //log in
                    login(loginResults.get(0).get("UserID"), loginResults.get(0).get("Admin"));
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(rootPanel, exc.toString());
                    clearTextBoxes();
                }
            }
        });
    }

    /**
     * Clear text boxes to prep for next entry
     */
    private void clearTextBoxes() {
        nameField.setText("");
        createUsernameField.setText("");
        emailField.setText("");
        createPasswordField.setText("");
        confirmPasswordField.setText("");
        loginUsernameField.setText("");
        loginPasswordField.setText("");
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    /**
     * Add a listener to be notified when a login occurs
     * @param toAdd the listener
     */
    public void addListener(LoginListener toAdd) {
        listeners.add(toAdd);
    }

    /**
     * Send the login signal to all listeners
     * @param UID the user id of the user logging in
     */
    private void login(String UID, String admin) {
        for (LoginListener ll : listeners) {
            ll.login(UID, admin);
        }
    }
}
