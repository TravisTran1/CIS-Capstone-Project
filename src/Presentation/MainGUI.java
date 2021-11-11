package Presentation;

import javax.swing.*;
import java.awt.*;

/**
 * Main GUI that operates all user interfaces
 * @author Josh Farrell and Travis Tran
 * @version 11/12/2020
 */
public class MainGUI implements LoginListener {
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;
    private JPanel sendNotification;
    private JPanel login;
    private JPanel template;
    private JPanel subscriberSettings;

    private int UID;

    public MainGUI() {
        UID = 0;
        rootPanel.setLayout(new GridLayout());
        rootPanel.setPreferredSize(new Dimension(650, 600));
        loadLoginPage();

        showLoginPage();
    }

    /**
     * initializes loginGUI and adds this class as a listener
     */
    private void loadLoginPage() {
        LoginGUI loginScreen = new LoginGUI();

        loginScreen.addListener(this);

        login = loginScreen.getRootPanel();
    }

    /**
     * Displays the login page
     */
    private void showLoginPage() {
        rootPanel.removeAll();
        rootPanel.add(login);
        rootPanel.repaint();
    }

    /**
     * Initializes the landing page
     */
    private void loadLandingPage(int UID) {
        tabbedPane1 = new JTabbedPane();

        MessageGUI message = new MessageGUI(UID);
        TempGUI temp = new TempGUI();
        NotificationSettingsGUI settingsGUI = new NotificationSettingsGUI(Integer.toString(UID));

        sendNotification = message.getRootPanel();
        template = temp.getRootPanel();
        subscriberSettings = settingsGUI.getRootPanel();
        tabbedPane1.add("Subscriber Settings", subscriberSettings);
    }

    /**
     * Displays the landing page
     */
    private void showLandingPage() {
        rootPanel.removeAll();
        rootPanel.add(tabbedPane1);
        rootPanel.revalidate();
    }

    /**
     * places admin function tabs on the GUI
     */
    private void addAdminFeatures() {
        tabbedPane1.add("Send Notification", sendNotification);
        tabbedPane1.add("Template Creation", template);
    }

    /**
     * Handles login events, taking the user to the landing page
     * @param UID the id of the logged in user
     */
    @Override
    public void login(String UID, String admin) {
        this.UID = Integer.parseInt(UID);
        loadLandingPage(this.UID);
        if (admin.equals("1")){ addAdminFeatures(); }
        showLandingPage();
    }

    /**
     * Return the root panel
     * @return rootPanel
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
