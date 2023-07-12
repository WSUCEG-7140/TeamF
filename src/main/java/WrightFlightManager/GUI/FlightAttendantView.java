package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//change functionality according to available database
//Issue no 49
public class FlightAttendantView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private FlightAttendantPanel flightAttendantPanel;

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
    private class FlightAttendantPanel extends JPanel {
        private JLabel flightInfoLabel;
        private JTextField flightNumberField;
        private JButton assignSeatButton;

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

