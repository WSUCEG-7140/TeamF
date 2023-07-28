package WrightFlightManager.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 * @class BaggageScreentoPassengerViewinGUI
 * @brief Represents a JFrame that displays passenger information and provides baggage scanning functionality.
 */
class BaggageScreentoPassengerViewinGUI extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2, baggageButton;
    Container con;
    JPanel passengerPanel, baggagePanel;
    CardLayout cardLayout;
    /**
     * @brief Default constructor for BaggageScreentoPassengerViewinGUI.
     * Sets up the GUI components and initializes the passenger and baggage panels.
     */
    BaggageScreentoPassengerViewinGUI() {
        super("Passenger View");
        setSize(500, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        con = getContentPane();

        // Passenger Panel
        passengerPanel = new JPanel();
        passengerPanel.setLayout(null);

        l1 = new JLabel("Passenger ID:");
        l2 = new JLabel("Passenger Name:");
        l3 = new JLabel("Passport No:");
        l4 = new JLabel("Flight No:");
        l5 = new JLabel("Age:");
        l6 = new JLabel("Seat No:");

        t1 = new JTextField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        t4 = new JTextField("");
        t5 = new JTextField("");
        t6 = new JTextField("");

        b1 = new JButton("Add");
        b2 = new JButton("Cancel");
        baggageButton = new JButton("Baggage Screen");

        l1.setBounds(50, 50, 150, 20);
        l2.setBounds(50, 100, 150, 20);
        l3.setBounds(50, 150, 150, 20);
        l4.setBounds(50, 200, 150, 20);
        l5.setBounds(50, 250, 150, 20);
        l6.setBounds(50, 300, 150, 20);

        t1.setBounds(250, 50, 150, 20);
        t2.setBounds(250, 100, 150, 20);
        t3.setBounds(250, 150, 150, 20);
        t4.setBounds(250, 200, 150, 20);
        t5.setBounds(250, 250, 150, 20);
        t6.setBounds(250, 300, 150, 20);

        b1.setBounds(150, 400, 80, 30);
        b2.setBounds(250, 400, 80, 30);
        baggageButton.setBounds(150, 450, 180, 30);

        passengerPanel.add(l1);
        passengerPanel.add(l2);
        passengerPanel.add(l3);
        passengerPanel.add(l4);
        passengerPanel.add(l5);
        passengerPanel.add(l6);
        passengerPanel.add(t1);
        passengerPanel.add(t2);
        passengerPanel.add(t3);
        passengerPanel.add(t4);
        passengerPanel.add(t5);
        passengerPanel.add(t6);
        passengerPanel.add(b1);
        passengerPanel.add(b2);
        passengerPanel.add(baggageButton);

        b1.addActionListener(this);
        b2.addActionListener(this);
        baggageButton.addActionListener(this);

        // Baggage Panel
        baggagePanel = new JPanel();
        BaggageScreenPanel baggageScreenPanel = new BaggageScreenPanel();
        baggagePanel.add(baggageScreenPanel);

        // CardLayout to switch between panels
        cardLayout = new CardLayout();
        con.setLayout(cardLayout);

        con.add(passengerPanel, "Passenger");
        con.add(baggagePanel, "Baggage");

        setVisible(true);
    }


    /**
     * @brief Handles action events for buttons.
     * @param ae The ActionEvent object representing the user's action.
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            // apply insert command
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            JOptionPane.showMessageDialog(null, "Passenger added successfully");
        }

        if (ae.getSource().equals(b2)) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
        }

        if (ae.getSource().equals(baggageButton)) {
            cardLayout.show(con, "Baggage");
        }
    }

    // Baggage Screen Panel

    /**
     * @class BaggageScreenPanel
     * @brief Represents the BaggageScreenPanel that provides baggage scanning functionality.
     */
    private class BaggageScreenPanel extends JPanel {
        private JLabel baggageInfoLabel;
        private JTextField baggageNumberField;
        private JButton scanBaggageButton;


        /**
         * @brief Constructor for BaggageScreenPanel.
         * Sets up the GUI components for baggage scanning.
         */
        public BaggageScreenPanel() {
            setLayout(new FlowLayout());

            baggageInfoLabel = new JLabel("Baggage Information:");
            baggageNumberField = new JTextField(10);
            scanBaggageButton = new JButton("Scan Baggage");

            add(baggageInfoLabel);
            add(baggageNumberField);
            add(scanBaggageButton);

            scanBaggageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String baggageNumber = baggageNumberField.getText();
                    /*
                    apply algorithms or operations on baggageNumber as per your requirements
                    */

                    // Display message for confirmation
                    JOptionPane.showMessageDialog(BaggageScreenPanel.this,
                            "Baggage scanned: " + baggageNumber,
                            "Baggage Scanning", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }
}

