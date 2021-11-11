package Presentation;

import javax.swing.*;
import java.awt.*;

public class TemplateMain {

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("Pantry Template");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TempGUI().getRootPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());

    }
}
