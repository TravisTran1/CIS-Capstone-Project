package Presentation;

import javax.swing.*;

/**
 * @author JOSH FARRELL & CARA TANG
 * @version 10/20/20
 * Main handling for login and account creation
 * JF: + javadoc
 */
public class LoginMain {
    public static void createAndShowGui() {
        JFrame frame = new JFrame("Food Pantry Notification System Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LoginGUI().getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> createAndShowGui());
    }
}
