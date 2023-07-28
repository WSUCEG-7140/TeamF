package WrightFlightManager.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @brief This class represents a graphical user interface (GUI) for creating Flight Attendant accounts in a system.
 * <p>
 * This class represents a graphical user interface (GUI) for creating Flight Attendant accounts in a system.
 * The class extends JFrame to create a main window for the account creation interface. It contains labels,
 * text fields, a combo box, and a button to capture user inputs for creating a new account. The account
 * information (username, password, and account type) is saved to a file after successful creation.
 */
public class FlightAttendantAccountCreationToGUI extends JFrame {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel accountTypeLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> accountTypeComboBox;
    private JButton createButton;
    /**
     * @brief Constructor for the FlightAttendantAccountCreationToGUI class.
     * <p>
     * Initializes the main frame and creates all the GUI components required for the account creation.
     * It sets the layout, size, and properties of the frame. Action listeners are registered for the
     * "Create Account" button to trigger the account creation process.
     */
    public FlightAttendantAccountCreationToGUI() {
        // Create the main frame
        setTitle("Add Flight Attendant to System");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Create the username label
        usernameLabel = createLabel("Username:", 50, 50, 100, 30);

        // Create the password label
        passwordLabel = createLabel("Password:", 50, 100, 100, 30);

        // Create the account type label
        accountTypeLabel = createLabel("Account Type:", 50, 150, 100, 30);

        // Create the input fields
        usernameField = createTextField(180, 50, 300, 30);
        passwordField = createPasswordField(180, 100, 300, 30);

        // Create the account type combo box
        String[] accountTypes = {"Type 1", "Type 2", "Type 3"};
        accountTypeComboBox = createComboBox(accountTypes, 180, 150, 300, 30);

        // Create the create button
        createButton = createButton("Create Account", 180, 200, 140, 30);

        // Add components to the frame
        add(usernameLabel);
        add(passwordLabel);
        add(accountTypeLabel);
        add(usernameField);
        add(passwordField);
        add(accountTypeComboBox);
        add(createButton);

        // Register action listeners for the buttons
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
    }
    /**
     * @brief Creates a JLabel with the given text at the specified position and dimensions.
     * @param text   The text to be displayed in the label.
     * @param x      The x-coordinate of the label's position.
     * @param y      The y-coordinate of the label's position.
     * @param width  The width of the label.
     * @param height The height of the label.
     * @return The created JLabel with the specified properties.
     */
    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }
    /**
     * @brief Creates a JTextField at the specified position and dimensions.
     * @param x      The x-coordinate of the text field's position.
     * @param y      The y-coordinate of the text field's position.
     * @param width  The width of the text field.
     * @param height The height of the text field.
     * @return The created JTextField with the specified properties.
     */
    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }
    /**
     * @brief Creates a JPasswordField at the specified position and dimensions.
     * @param x      The x-coordinate of the password field's position.
     * @param y      The y-coordinate of the password field's position.
     * @param width  The width of the password field.
     * @param height The height of the password field.
     * @return The created JPasswordField with the specified properties.
     */
    private JPasswordField createPasswordField(int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, width, height);
        return passwordField;
    }
    /**
     * @brief Creates a JComboBox (combo box) with the given options at the specified position and dimensions.
     * @param options An array of strings representing the options for the combo box.
     * @param x       The x-coordinate of the combo box's position.
     * @param y       The y-coordinate of the combo box's position.
     * @param width   The width of the combo box.
     * @param height  The height of the combo box.
     * @return The created JComboBox with the specified properties.
     */
    private JComboBox<String> createComboBox(String[] options, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, width, height);
        return comboBox;
    }

    /**
     * @brief Creates a JButton with the given label at the specified position and dimensions.
     * @param label  The label (text) to be displayed on the button.
     * @param x      The x-coordinate of the button's position.
     * @param y      The y-coordinate of the button's position.
     * @param width  The width of the button.
     * @param height The height of the button.
     * @return The created JButton with the specified properties.
     */
    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

    /**
     * @brief Creates an account based on the user inputs and saves it to a file.
     * This method is called when the "Create Account" button is pressed. It retrieves the username, password,
     * and account type from the GUI components and performs validation on the input fields. If any field is
     * empty, it shows an error message. Otherwise, it creates an account string and saves it to a file.
     * The method also clears the input fields after successful account creation and displays a success message.
     */
    private void createAccount() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String accountType = (String) accountTypeComboBox.getSelectedItem();

        // Perform validation of the input fields
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields");
            return;
        }

        // Create the account string
        String account = username + "|" + password + "|" + accountType;

        // Save the account to a file
        saveAccountToFile(account);

        // Clear the input fields
        clearFields();

        JOptionPane.showMessageDialog(this, "Account created successfully!");
    }
    /**
     * @brief Saves the account information to a file.
     * @param account The account string to be saved.
     */
    private void saveAccountToFile(String account) {
        try {
            FileWriter writer = new FileWriter("accounts.psv", true);
            writer.write(account + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @brief Clears the input fields.
     * This method is called after a successful account creation to reset the input fields.
     */
    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}
