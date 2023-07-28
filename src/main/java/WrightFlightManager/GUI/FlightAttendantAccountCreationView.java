package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class FlightAttendantAccountCreationView
 * @brief This class represents the graphical user interface for creating flight attendant accounts.
 *
 * The FlightAttendantAccountCreationView class extends JFrame to create the main frame for the GUI.
 * It allows the user to create a new flight attendant account by entering relevant information.
 * The class includes methods to create buttons, labels, text fields, and password fields for the GUI.
 *
 * @note This class uses a null layout, which may not be recommended for production GUI development.
 */
public class FlightAttendantAccountCreationView extends JFrame {

    private JButton createAccountButton;

    /**
     * @brief Default constructor for FlightAttendantAccountCreationView.
     *
     * This constructor initializes the main frame and sets its properties such as title, size,
     * default close operation, location, and resizability. It also creates the "Create Account" button
     * and adds it to the frame. An action listener is registered for the button to handle its clicks.
     * When the button is clicked, a new FlightAttendantAccountCreationView object is created and made visible.
     *
     * @note The action listener creates a new instance of the class, which might not be the desired behavior.
     * It appears to create a new identical window for account creation when the button is clicked.
     * You might want to change this behavior if it's not intended.
     */
    public FlightAttendantAccountCreationView () {
        // Create the main frame
        setTitle("Flight Attendant System");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Create the create account button
        createAccountButton = createButton("Create Flight Attendant Account", 180, 200, 240, 30);

        // Add components to the frame
        add(createAccountButton);

        // Register action listeners for the buttons
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightAttendantAccountCreationView ob = new FlightAttendantAccountCreationView();
                ob.setVisible(true);
            }
        });
    }

    /**
     * @brief Creates a JButton with the specified label and position.
     *
     * This function creates a new JButton with the given label and sets its position
     * within the container using the provided coordinates and size.
     *
     * @param label The label to be displayed on the button.
     * @param x The X-coordinate of the button's top-left corner.
     * @param y The Y-coordinate of the button's top-left corner.
     * @param width The width of the button.
     * @param height The height of the button.
     *
     * @return A new JButton instance with the specified label and position.
     */
    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

    /**
     * @brief Creates a JLabel with the specified text and position.
     *
     * This function creates a new JLabel with the given text and sets its position
     * within the container using the provided coordinates and size.
     *
     * @param text The text to be displayed on the label.
     * @param x The X-coordinate of the label's top-left corner.
     * @param y The Y-coordinate of the label's top-left corner.
     * @param width The width of the label.
     * @param height The height of the label.
     *
     * @return A new JLabel instance with the specified text and position.
     */
    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    /**
     * @brief Creates a JTextField with the specified position and size.
     *
     * This function creates a new JTextField and sets its position within the container
     * using the provided coordinates and size.
     *
     * @param x The X-coordinate of the text field's top-left corner.
     * @param y The Y-coordinate of the text field's top-left corner.
     * @param width The width of the text field.
     * @param height The height of the text field.
     *
     * @return A new JTextField instance with the specified position and size.
     */
    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }

    /**
     * @brief Creates a JPasswordField with the specified position and size.
     *
     * This function creates a new JPasswordField and sets its position within the container
     * using the provided coordinates and size.
     *
     * @param x The X-coordinate of the password field's top-left corner.
     * @param y The Y-coordinate of the password field's top-left corner.
     * @param width The width of the password field.
     * @param height The height of the password field.
     *
     * @return A new JPasswordField instance with the specified position and size.
     */
    private JPasswordField createPasswordField(int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, width, height);
        return passwordField;
    }
}
