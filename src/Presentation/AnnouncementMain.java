package Presentation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Travis Tran & Tessa Henson
 *  * @version 2020.11.16
 * Print announcements sent out by staff
 */
public class AnnouncementMain {

    // Displays UI
    public static void createAndShowGui() {
        JFrame frame = new JFrame("Announcements - Notification Log");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AnnouncementsGUI().getRootPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> createAndShowGui());
    }
}
