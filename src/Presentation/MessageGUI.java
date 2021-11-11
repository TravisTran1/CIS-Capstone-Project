package Presentation;

import Logic.MessageLogging;
import Logic.MessageSMS;
import Logic.MessageEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Travis Tran
 * @version 2020.11.15
 * Create the Message GUI
 *
 * TT: added action listener to take text from the text fields
 * TT: interfaced with SubscriberEmail
 * TT: interfaced with MessageLogging
 * TT: sends emails and logs messages
 * TT: added input validation
 * TT: now checks for valid admin account before sending
 * TT: added error message for null fields
 * TT: clears text fields and area after sending
 * TT: added error message handling popups for database exceptions
 * TT: no longer uses senderTextField and instead passes UID from log in
 */

public class MessageGUI {
    private JTextField subjectTextField;
    private JPanel rootPanel;
    private JTextArea messageBody;
    private JButton sendButton;

    /**
     * Construct GUI
     * When button is pressed it will take the text fields and add the message to
     * the MS_Notification table.
     */
    public MessageGUI(int UID) {
        MessageLogging log = new MessageLogging();
        MessageEmail email = new MessageEmail();
        MessageSMS sms = new MessageSMS();
        rootPanel.setPreferredSize(new Dimension(500, 300));

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subject = subjectTextField.getText();
                String body = messageBody.getText();
                int foreignKey = UID;

                String date = log.getDate();

                try {
                    if (subject.equals("") || body.equals("")) {
                        JOptionPane.showMessageDialog(rootPanel, "Please completely fill out the form before sending.");

                    } else {
                        if (subject.length() < 100 && body.length() < 2147483647){
                            log.logMessage(subject, body, foreignKey, date);
                            email.sendEmail(subject, body);
                            sms.sendSMS(body);

                            JOptionPane.showMessageDialog(rootPanel, "Message successfully sent and logged");

                            clearTextBoxes();

                        } else {
                            JOptionPane.showMessageDialog(rootPanel, "Subject must not be more than 100 characters. Message not sent.");
                        }
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(rootPanel, exc.getMessage());
                }

            }
        });
    }

    /**
     * Clears text boxes
     */
    private void clearTextBoxes() {
        subjectTextField.setText("");
        messageBody.setText("");
    }

    /**
     * Return the root panel
     * @return rootPanel
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }

}
