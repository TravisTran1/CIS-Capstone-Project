package Presentation;

import javax.swing.*;

/**
 * @author Travis Tran
 * @version 2020.11.10
 * create unified GUI for user stories
 */

public class MainGUIMain {
    public static void createAndShowGui() {
        JFrame frame = new JFrame("Food Pantry Notification");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainGUI().getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> createAndShowGui());
    }

}
