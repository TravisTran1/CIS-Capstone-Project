package Presentation;

import Logic.AccountEditsForm;
import Logic.AccountEditsHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * GUI that handles notification settings
 * @author Josh Farrell
 * @version 12/02/20
 */
public class NotificationSettingsGUI {
    private JPanel rootPanel;

    private JRadioButton receiveEmailButton;
    private JRadioButton dontReceiveEmailButton;
    private ButtonGroup emailButtons;

    private JRadioButton receiveSMSButton;
    private JRadioButton dontReceiveSMSButton;
    private ButtonGroup smsButtons;

    private JButton editSMSButton;
    private JButton saveButton;

    private JLabel emailLabel;
    private JLabel smsNumLabel;
    private JTextField emailField;
    private JTextField smsField;

    private JPanel smsSettings;
    private JPanel emailSettings;

    private String uid;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public NotificationSettingsGUI(String uid) {
        this.uid = uid;

        emailButtons = new ButtonGroup();
        emailButtons.add(receiveEmailButton);
        emailButtons.add(dontReceiveEmailButton);

        smsButtons = new ButtonGroup();
        smsButtons.add(receiveSMSButton);
        smsButtons.add(dontReceiveSMSButton);

        //initialize fields
        setStartingValues();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountEditsForm form = new AccountEditsForm(Integer.parseInt(uid), emailField.getText(), smsField.getText(), getSendEmail(), getSendSMS());
                try {
                    AccountEditsHandler.editNotifications(form);
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(rootPanel, exc.getMessage());
                }
            }
        });
    }

    /**
     * Sets the starting values for the fields in this gui
     */
    private void setStartingValues() {
        HashMap<String, String> startingValues;
        try {
            startingValues = AccountEditsHandler.getNotificationSettings(uid);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(rootPanel,"An error was encountered retrieving your data: \n" + exc.getMessage());
            return;
        }
        emailField.setText(startingValues.get("Email"));
        try {
            smsField.setText(startingValues.get("Phone"));
        } catch (NullPointerException exc) {
            smsField.setText("");
        }
        setSendEmail(Integer.parseInt(startingValues.get("SendEmail")));
        setSendSMS(Integer.parseInt(startingValues.get("SendSMS")));
    }

    /**
     * This function tells the caller which radio button in the emailButtons group is selected
     * @return 1 if receiveEmailButton is selected, 0 if dontReceiveEmailButton is selected, -1 for neither
     */
    private int getSendEmail() {
        if (receiveEmailButton.isSelected()) {
            return 1;
        } else if (dontReceiveEmailButton.isSelected()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Sets the radio buttons in the emailButtons group to the specified value
     * @param sendEmail Sets receiveEmailButton if 1 is provided, dontReceiveEmailButton if 0 is provided, shows an error message otherwise
     */
    private void setSendEmail(int sendEmail) {
        if (sendEmail == 1) {
            receiveEmailButton.setSelected(true);
        } else if (sendEmail == 0) {
            dontReceiveEmailButton.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(rootPanel, "An Error occurred with the radio buttons");
        }
    }

    /**
     * This function tells the caller which radio button in the smsButtons group is selected
     * @return 1 if receiveEmailButton is selected, 0 if dontReceiveEmailButton is selected, -1 for neither
     */
    private int getSendSMS() {
        if (receiveSMSButton.isSelected()) {
            return 1;
        } else if (dontReceiveSMSButton.isSelected()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Sets the radio buttons in the smsButtons group to the specified value
     * @param  sendSMS Sets receiveEmailButton if 1 is provided, dontReceiveEmailButton if 0 is provided, shows an error message otherwise
     */
    private void setSendSMS(int sendSMS) {
        if (sendSMS == 1) {
            receiveSMSButton.setSelected(true);
        } else if (sendSMS == 0) {
            dontReceiveSMSButton.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(rootPanel, "An Error occurred with the radio buttons");
        }
    }
}
