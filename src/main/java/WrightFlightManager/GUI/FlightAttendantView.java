package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//change functionality according to available database
//Issue no 49
/**
 * @file FlightAttendantView.java
 *
 * @brief Contains the definition of the FlightAttendantView class, which extends JFrame.
 *
 */

/**
 * @class FlightAttendantView
 *
 * @brief Represents the graphical view for the FlightAttendantPanel using JFrame.
 *
 * This class provides a graphical user interface for the flight attendant to interact with the Flight Control System.
 *
 */
public class FlightAttendantView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private FlightAttendantPanel flightAttendantPanel;

    /**
     * @brief Constructor for FlightAttendantView class.
     *
     * Initializes the FlightAttendantView GUI.
     * Sets up the main JFrame properties, creates and adds a FlightAttendantPanel to the main panel,
     * and sets the main panel as the content pane for the frame.
     */
    public FlightAttendantView() {
        setTitle("Flight Control System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        flightAttendantPanel = new FlightAttendantPanel();
        mainPanel.add(flightAttendantPanel, "FlightAttendantPanel");

        getContentPane().add(mainPanel);

        setVisible(true);
    }

    //create a FlightAttendantPanel
    /**
     * @class FlightAttendantPanel
     *
     * @brief Represents the panel for flight attendant actions, which extends JPanel.
     *
     * This inner class provides a panel that allows the flight attendant to assign seats for flights.
     */
    private class FlightAttendantPanel extends JPanel {
        private JLabel flightInfoLabel;
        private JTextField flightNumberField;
        private JButton assignSeatButton;

        /**
         * @brief Constructor for FlightAttendantPanel class.
         *
         * Initializes the FlightAttendantPanel GUI.
         * Sets up the layout and components such as flight information label, flight number field, and assign seat button.
         * Adds an ActionListener to the assignSeatButton to handle seat assignment and display a confirmation message.
         */
        public FlightAttendantPanel() {
            setLayout(new FlowLayout());

            flightInfoLabel = new JLabel("Flight Information:");
            flightNumberField = new JTextField(10);
            assignSeatButton = new JButton("Assign Seat");

            add(flightInfoLabel);
            add(flightNumberField);
            add(assignSeatButton);

            assignSeatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String flightNumber = flightNumberField.getText();
                    /* add other data as per the database
                    ---
					---
					*/
                    // Display message for confirmation
                    JOptionPane.showMessageDialog(FlightAttendantPanel.this,
                            "Seat assigned for flight: " + flightNumber,
                            "Seat Assignment", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }
}

