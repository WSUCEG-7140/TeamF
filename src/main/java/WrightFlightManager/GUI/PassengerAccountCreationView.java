package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @class PassengerAccountCreationView
 *
 * @brief This class represents a graphical user interface (GUI) for creating passenger accounts.
 *        It extends the JFrame class and provides fields for the passenger's name, email, and password,
 *        along with a button to create the account.
 */public class PassengerAccountCreationView extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton createAccountButton;
    /**
     * This class represents a view for creating a passenger account.
     * It provides input fields for the user to enter their name, email, and password,
       and a button to create the account.
     */
    public PassengerAccountCreationView () {
        setTitle("Passenger Account Creation");
        setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 25);
        add(nameField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 200, 25);
        add(emailField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 100, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 100, 200, 25);
        add(passwordField);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(20, 140, 280, 25);
        createAccountButton.addActionListener(new ActionListener() {
            /**
             * This method is called when the "createAccountButton" is clicked. It handles the action
             * by extracting the name, email, and password from their respective input fields, saving the
             * data to a PSV (Pipe-Separated Values) file, and then clearing the input fields.
             *
             * @param e The ActionEvent representing the button click event.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Save data to PSV file
                saveData(name, email, password);

                // Clear input fields
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        });
        add(createAccountButton);

        setSize(330, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Saves passenger data to a file in pipe-separated values (PSV) format.
     *
     * @param name     The name of the passenger.
     * @param email    The email address of the passenger.
     * @param password The password of the passenger.
     */
    private void saveData(String name, String email, String password) {
        try (FileWriter writer = new FileWriter("PassengerAccounts.psv", true)) {
            String line = name + "|" + email + "|" + password + "\n";
            writer.write(line);
            JOptionPane.showMessageDialog(null,"Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}