package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @class PassengerAccountCreationToGUI
 * @brief A class representing the GUI for flight system account creation.
 *
 * This class extends the JFrame class to create a graphical user interface for users to input flight details
 * and create new flights in the flight system. It provides input fields for flight ID, origin, destination,
 * aircraft, departure, and arrival. Users can fill in the required details and click the "Create" button to
 * save the flight information to a file. The class also includes methods to create text fields, buttons, and
 * perform flight creation and file saving operations.
 */
public class PassengerAccountCreationToGUI extends JFrame {

    private JTextField flightIdField;
    private JTextField originField;
    private JTextField destinationField;
    private JTextField aircraftField;
    private JTextField departureField;
    private JTextField arrivalField;
    private JButton createButton;

    /**
     * @brief Constructor for PassengerAccountCreationToGUI.
     *
     * This constructor sets up the main frame for the GUI. It initializes the window title, size, and layout.
     * It creates input fields for flight ID, origin, destination, aircraft, departure, and arrival. The
     * "Create" button is also created. Action listeners are registered for the "Create" button to trigger the
     * flight creation process when clicked.
     */
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

    /**
     * @brief Creates a text field with the specified label and position.
     *
     * This private method is used internally to create input text fields with specified labels and positions.
     *
     * @param label The label to be displayed for the text field.
     * @param x The X-coordinate of the text field's position.
     * @param y The Y-coordinate of the text field's position.
     * @param width The width of the text field.
     * @param height The height of the text field.
     * @return JTextField A new JTextField object with the specified properties.
     */
    private JTextField createTextField(String label, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder(label));
        textField.setBounds(x, y, width, height);
        return textField;
    }

    /**
     * @brief Creates a button with the specified label and position.
     *
     * This private method is used internally to create buttons with specified labels and positions.
     *
     * @param label The label to be displayed on the button.
     * @param x The X-coordinate of the button's position.
     * @param y The Y-coordinate of the button's position.
     * @param width The width of the button.
     * @param height The height of the button.
     * @return JButton A new JButton object with the specified properties.
     */
    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

    /**
     * @brief Creates a new flight based on the user input and saves it to a file.
     *
     * This method is called when the "Create" button is clicked. It retrieves the flight details from the
     * input fields, performs validation, and creates a flight string. The flight string is then saved to
     * a file named "Flights.psv" in the pipe-separated values format. After successful creation and saving
     * of the flight, the input fields are cleared, and a success message is displayed to the user.
     */
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

    /**
     * @brief Saves the given flight string to the "Flights.psv" file.
     *
     * This private method is used internally to save the flight details to a file in the pipe-separated values
     * format. The file is opened in append mode, and the flight string is written as a new line in the file.
     *
     * @param flight The flight string to be saved to the file.
     */
    private void saveFlightToFile(String flight) {
        try {
            FileWriter writer = new FileWriter("Flights.psv", true);
            writer.write(flight + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Clears all the input fields in the GUI.
     *
     * This private method is used internally to reset all the input fields to empty strings after a flight
     * has been created and saved.
     */
    private void clearFields() {
        flightIdField.setText("");
        originField.setText("");
        destinationField.setText("");
        aircraftField.setText("");
        departureField.setText("");
        arrivalField.setText("");
    }
}

