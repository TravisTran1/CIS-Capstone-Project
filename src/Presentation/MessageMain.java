package Presentation;

import javax.swing.*;

/**
 * @author Travis Tran
 * @version 2020.11.18
 * Send messages to subscribers in the database
 *
 */
public class MessageMain {

    public static void createAndShowGui() {
        int UID = 1;
        JFrame frame = new JFrame("Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MessageGUI(UID).getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> createAndShowGui());
    }
}
