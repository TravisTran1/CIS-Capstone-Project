package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.CreateTemplate;

public class TempGUI {
    //TODO Use the link below as reference for adding the scroll bar, prevents text going out the window
    /*
    https://stackoverflow.com/questions/16745410/how-to-stop-jtextfields-from-running-off-the-frame
     */
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton saveButton;
    private JTextArea bodyTextArea;
    private JTextField textSubject;
    private JTextField textName;
    private JScrollPane bodyScrollArea;

    public TempGUI() {

        rootPanel.setPreferredSize(new Dimension(750, 650));

        saveButton.addActionListener(new ActionListener() {
            int saveReady = 0;
            @Override
            public void actionPerformed(ActionEvent e) {

                if (bodyTextArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPanel, "Body cannot be empty.");
                    bodyTextArea.getText();
                    bodyTextArea.getText().equals("");
                }
                saveReady++;

                if (textSubject.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPanel, "Subject cannot be empty.");
                    textSubject.getText();
                    textSubject.getText().equals("");
                }
                saveReady++;

                if (textName.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPanel, "Name cannot be empty.");
                    textName.getText();
                    textName.getText().equals("");
                }
                saveReady++;

                switch(saveReady) {
                    case 0:
                    case 1:
                    case 2:
                        JOptionPane.showMessageDialog(rootPanel, "Cannot save, please check your template");
                        break;
                    case 3:
                        CreateTemplate template = new CreateTemplate(textName.getText(),
                                                                    textSubject.getText(),
                                                                    bodyTextArea.getText());

                        JOptionPane.showMessageDialog(rootPanel, "Template saved!");
                }

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
