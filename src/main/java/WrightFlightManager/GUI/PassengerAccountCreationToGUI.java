package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class PassengerAccountCreationToGUI extends JFrame {

    private JTextField flightIdField;
    private JTextField originField;
    private JTextField destinationField;
    private JTextField aircraftField;
    private JTextField departureField;
    private JTextField arrivalField;
    private JButton createButton;

    public PassengerAccountCreationToGUI () {
        // Create the main frame
        setTitle("Flight System");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Create the input fields
        flightIdField = createTextField("Flight ID", 20, 20, 160, 30);
        originField = createTextField("Origin", 20, 60, 160, 30);
        destinationField = createTextField("Destination", 20, 100, 160, 30);
        aircraftField = createTextField("Aircraft", 20, 140, 160, 30);
        departureField = createTextField("Departure", 20, 180, 160, 30);
        arrivalField = createTextField("Arrival", 20, 220, 160, 30);

        // Create the create button
        createButton = createButton("Create", 200, 140, 160, 30);

        // Add components to the frame
        add(flightIdField);
        add(originField);
        add(destinationField);
        add(aircraftField);
        add(departureField);
        add(arrivalField);
        add(createButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Register action listeners for the buttons
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFlight();
            }
        });
    }

    private JTextField createTextField(String label, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder(label));
        textField.setBounds(x, y, width, height);
        return textField;
    }

    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

    private void createFlight() {
        String flightId = flightIdField.getText();
        String origin = originField.getText();
        String destination = destinationField.getText();
        String aircraft = aircraftField.getText();
        String departure = departureField.getText();
        String arrival = arrivalField.getText();

        // Perform validation of the input fields
        if (flightId.isEmpty() || origin.isEmpty() || destination.isEmpty() ||
                aircraft.isEmpty() || departure.isEmpty() || arrival.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields");
            return;
        }

        // Create the flight string
        String flight = flightId + "|" + origin + "|" + destination + "|" +
                aircraft + "|" + departure + "|" + arrival;

        // Save the flight to a file
        saveFlightToFile(flight);

        // Clear the input fields
        clearFields();

        JOptionPane.showMessageDialog(this, "Flight created successfully!");
    }

    private void saveFlightToFile(String flight) {
        try {
            FileWriter writer = new FileWriter("Flights.psv", true);
            writer.write(flight + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        flightIdField.setText("");
        originField.setText("");
        destinationField.setText("");
        aircraftField.setText("");
        departureField.setText("");
        arrivalField.setText("");
    }
}

