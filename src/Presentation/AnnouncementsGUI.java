package Presentation;

import Logic.Announcement;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Travis Tran & Jesus Sandoval & Tessa Henson
 * @version 2020.12.07
 * Create the Announcement GUI
 *
 * TT: added date selection
 * TT: added table
 * JS: Update Authors
 * JS: Deleted Year text and Year ComboBox.
 * JS: Renamed combo box to fromDateComboBox
 * JS: Renamed combo box to toDateComboBox
 * JS: Added # of subscribers column
 * JS: Modified getValueAt for case 5 : return announcements.get(row).getNumOfSubscribers();
 * TH: Created a darker theme (as well as the rest of the guis), modified the overall look
 * TH: Validation is fixed
 * TH: Removed methods that weren't being used
 * TH: Created listener for when user clicks on a row, presents corresponding message in message box
 * TH: Naming conventions on the gui are more user friendly
 * TH: More validation fixes
 */

public class AnnouncementsGUI {
    private JTable announcementsTable;
    private JPanel rootPanel;
    private JScrollPane messageScrollPane;
    private JTextPane textPaneMessage;
    private JScrollPane announceScrollPane;
    private JTextField txtFldFromDate;
    private JTextField txtFldToDate;
    private JButton btnDate;
    private JLabel fromDateLabel;
    private JLabel toDateLabel;
    private AnnouncementsTableModel tableModel;

    /**
     * Construct GUI
     */
    public AnnouncementsGUI() {
        rootPanel.setPreferredSize(new Dimension(750, 650));
        tableModel = new AnnouncementsTableModel(new ArrayList<>());
        announcementsTable.setModel(tableModel);

        final ArrayList<HashMap<String, String>>[] dataList = new ArrayList[]{new ArrayList<HashMap<String, String>>()};
        Announcement announcement = new Announcement();

        //When the user inputs dates
        btnDate.addActionListener(new ActionListener() {
            int searchReady = 0;
            boolean resetSearch = false;
            boolean switchFromDate = false;
            boolean switchToDate = false;
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtFldFromDate.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPanel, "Lower date range needs to be entered.\n" +
                            "(Ex: January 9, 2020 is 2020-01-09).");
                    resetSearch = true;
                    txtFldFromDate.getText();
                    txtFldFromDate.getText().equals("");
                }
                Date fromDate = null;
                Date toDate = null;

                if (!resetSearch) {
                    //Lower date range validation
                    try {
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        fromDate = dateFormat1.parse(txtFldFromDate.getText());
                        switchFromDate = true;
                        System.out.println("fromDate went through");
                        announcement.setFromDate(txtFldFromDate.getText());
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "\nLower Date range: Please make sure the date is entered in correctly " +
                                        "\n(Ex: January 9, 2020 is entered as 2020-01-09).");
                        System.out.println("Error is as follows: " + err);
                    }

                    //Upper date range validation
                    try {
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                        toDate = dateFormat2.parse(txtFldToDate.getText());
                        if (fromDate.after(toDate)) { //toDate.getDate() < fromDate.getDate()) {
                            JOptionPane.showMessageDialog(rootPanel, "Upper date range needs to be entered past lower date range,\n" +
                                    "the date can be the same as the other (Ex: From 2020-11-16 to 2020-11-16)");
                            txtFldToDate.getText();
                        } else {
                            switchToDate = true;
                            System.out.println("toDate went through successfully");
                            announcement.setToDate(txtFldToDate.getText());
                        }

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "\nUpper Date range: Please make sure the date is entered in correctly " +
                                        "\n(Ex: January 9, 2020 is entered as 2020-01-09).");
                        System.out.println("Error is as follows: " + err);
                    }
                } else {
                    System.out.println("resetSearch found true");
                    resetSearch = false;
                }
                /*
                //Lower date range validation
                try {
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    fromDate = dateFormat1.parse(txtFldFromDate.getText());
                    switchFromDate = true;
                    System.out.println("fromDate went through");
                    announcement.setFromDate(txtFldFromDate.getText());
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "\nPlease make sure the date is entered in correctly " +
                            "\n(Ex: January 9, 2020 is entered as 2020-01-09).");
                    System.out.println("Error is as follows: " + err);
                }

                //Upper date range validation
                try {
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                    toDate = dateFormat2.parse(txtFldToDate.getText());
                        if (fromDate.after(toDate)) { //toDate.getDate() < fromDate.getDate()) {
                            JOptionPane.showMessageDialog(rootPanel, "Upper date range needs to be entered past lower date range,\n" +
                                    "the date can be the same as the other (Ex: From 2020-11-16 to 2020-11-16)");
                            txtFldToDate.getText();
                        } else {
                            switchToDate = true;
                            System.out.println("toDate went through successfully");
                            announcement.setToDate(txtFldToDate.getText());
                        }

                } catch (Exception err) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "\nPlease make sure the date is entered in correctly " +
                                    "\n(Ex: January 9, 2020 is entered as 2020-01-09).");
                    System.out.println("Error is as follows: " + err);
                }

                 */

                //Confirmed date validation, presents rows to user
                if (switchFromDate && switchToDate) {
                    tableModel.setNumRows(0);
                    ArrayList<Announcement> announcements = new ArrayList<>();
                    dataList[0] = announcement.dataArr();
                    System.out.println(dataList[0]);

                    for (int i = 0; i < dataList[0].size(); i++) {
                        String dDate = dataList[0].get(i).get("DateCreated");
                        int dSenderID = Integer.parseInt(dataList[0].get(i).get("UserID"));
                        int dSentTo = Integer.parseInt(dataList[0].get(i).get("SentTo"));
                        String dSubject = dataList[0].get(i).get("Subject");
                        String dMessage = dataList[0].get(i).get("Message");

                        Object[] row = {dDate, dSenderID, dSentTo, dSubject, dMessage};
                        tableModel.addRow(row);
                    }
                }
            }
        });

        //Checks to see if user clicks on a row, expands message sent into the message box below
        announcementsTable.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    textPaneMessage.setText("");
                    textPaneMessage.setText(announcementsTable.getValueAt(announcementsTable.getSelectedRow(), 4).toString());
                }
            }
        );
    }

    /**
     * Return the root panel
     * @return rootPanel
     */
    public JPanel getRootPanel() {
        return rootPanel;
    }

    /**
     * Constructs table
     */
    private class AnnouncementsTableModel extends DefaultTableModel {
        private final String[] COL_NAMES = {"Date", "Sender ID", "Sent to", "Subject", "Message"};
        private List<Announcement> announcements;

        public AnnouncementsTableModel(List<Announcement> announcements) {
            super();
            this.announcements = announcements;

            setColumnIdentifiers(COL_NAMES);
            setRowCount(announcements.size());
        }

        public void setAnnouncements(List<Announcement> announcements) {
            this.announcements = announcements;
            setRowCount(announcements.size());
        }
    }
}
