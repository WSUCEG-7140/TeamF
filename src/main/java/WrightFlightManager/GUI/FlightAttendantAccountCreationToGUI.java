package WrightFlightManager.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class FlightAttendantAccountCreationToGUI extends JFrame {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel accountTypeLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> accountTypeComboBox;
    private JButton createButton;

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

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }

    private JPasswordField createPasswordField(int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, width, height);
        return passwordField;
    }

    private JComboBox<String> createComboBox(String[] options, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, width, height);
        return comboBox;
    }

    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

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

    private void saveAccountToFile(String account) {
        try {
            FileWriter writer = new FileWriter("accounts.psv", true);
            writer.write(account + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlightAttendantAccountCreationToGUI system = new FlightAttendantAccountCreationToGUI();
                system.setVisible(true);
            }
        });
    }
}

